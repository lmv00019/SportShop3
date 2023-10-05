package es.ujaen.daw.tiendadeporte;


import es.ujaen.daw.tiendadeporte.usuarios.Usuario;
import jakarta.enterprise.context.SessionScoped;
        import jakarta.inject.Named;
        import java.io.Serializable;

@Named(value="prefs")
@SessionScoped
public class Preferencias implements Serializable {
    private Usuario usuario;

    public Preferencias() {};

    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}