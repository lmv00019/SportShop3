package es.ujaen.daw.tiendadeporte.usuarios;

import es.ujaen.daw.tiendadeporte.DAOJpa;
import es.ujaen.daw.tiendadeporte.usuarios.Usuario;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import es.ujaen.daw.tiendadeporte.Preferencias;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;


@Named(value = "ctrlUsuario")
@ViewScoped
public class UsuarioController implements Serializable {

    @Inject
    Preferencias preferencias;

    @Inject HttpServletRequest request; //acceso al objeto request de la petición actual
    //...
    public String logout() throws ServletException {
        request.logout();
        request.getSession().invalidate();
        return "/Index2?faces-redirect=true"; //PRG
    }


    private static final long serialVersionUID = 1L;
    private final Logger logger = Logger.getLogger(UsuarioController.class.getName());
    @Inject  @DAOJpa
    private UsuarioDAO usuarioDAO;
    @Inject
    FacesContext fc;
    private Usuario usuario;
    //private UsuarioController request;
    public UsuarioController(){}
    @PostConstruct
    private void init(){
        usuario = new Usuario();
    }
    public List<Usuario> getUsuarios(){return usuarioDAO.buscaTodos();}

    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void recupera() {
        usuario = usuarioDAO.buscaId(usuario.getId());
        //preferencias.setUsuario(usuario);

        if (usuario == null) {
            fc.addMessage(null, new FacesMessage("El usuario indicado no existe"));
        }
    }

    public String crea() {
        usuario.setId(0);
        usuarioDAO.crea(usuario);
        //Post-Redirect-Get
        return "/Index2?faces-redirect=true&id" + usuario.getId();
    }

    public String registro() {
        usuario.setId(0);
        usuario.setAdministrador(false);
        usuarioDAO.crea(usuario);
        //Post-Redirect-Get
        return "/Index2?faces-redirect";
    }

    public String guarda() {
        usuarioDAO.guarda(usuario);
        return "/Index2?faces-redirect=true&id=" + usuario.getId();
    }

    public String borra() {
        usuarioDAO.borra(usuario.getId());
        return "listadoUsuarios";
    }

    public String borra(Usuario usuario) {
        usuarioDAO.borra(usuario.getId());
        return "listadoUsuarios";
    }

    /*public String modifica(Integer id, String nombre, String dni) {
        Usuario u;
        //u = UsuarioDAOMap.buscaId(id);
        u.setNombre(nombre);
        u.setDni(dni);
        //Post-Redirect-Get
        return "/Index2?faces-redirect=true&id" + u.getId();
    }*/
}