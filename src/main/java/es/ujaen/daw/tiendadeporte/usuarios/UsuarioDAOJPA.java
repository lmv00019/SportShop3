package es.ujaen.daw.tiendadeporte.usuarios;

import es.ujaen.daw.tiendadeporte.DAOJpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 *
 * @author Alberto Martínez y Lorena Moreno
 */
@RequestScoped  //Elegible for Dependency Injection
@DAOJpa
@Transactional  //Application Server automatically manages EntityManager transaction in every method
public class UsuarioDAOJPA implements UsuarioDAO, Serializable {

    private final Logger logger = Logger.getLogger(UsuarioDAOJPA.class.getName());

    @PersistenceContext(unitName = "tiendaDep") //Only for JEE full application servers
    //Requires to enable Persistence-unit in persistence.xml
    private EntityManager em;

    public UsuarioDAOJPA() {
    }

    @Override
    public Usuario buscaId(Integer id) {
        Usuario u=null;
        try {
            u=em.find(Usuario.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return u;
    }
    @Override
    public List<Usuario> buscaTodos() {
        List<Usuario> lu = null;
        try {
            Query q = em.createQuery("Select u from Usuario u", Usuario.class);
            lu = (List<Usuario>)q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lu;
    }

    public Usuario buscaDni(String dni) {
        Usuario u = null;
        try {
            TypedQuery<Usuario> q = em.createQuery("Select u from Usuario u where u.dni=:dni",Usuario.class);
            q.setParameter("dni", dni);
            u = q.getSingleResult();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return u;
    }

    public Usuario buscaEmail(String email) {
        Usuario u = null;
        try {
            TypedQuery<Usuario> q = em.createQuery("Select u from Usuario u where u.email=:email",Usuario.class);
            q.setParameter("email", email);
            u = q.getSingleResult();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return u;
    }

    /** Sample nativeQuery method*/
    public List<String> buscaDnis() {
        List<String> l = new ArrayList<>();
        try {
            Query q = em.createNativeQuery("Select dni,nombre from Usuario");
            //No mapping entity
            List<Objects[]> lt = q.getResultList();
            for (Object[] o : lt) {
                //Access fields using ordinal position
                l.add( o[0].toString() );
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;
    }

    @Override
    public boolean crea(Usuario u) {
        boolean creado = false;
        try {
            em.persist(u);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

    @Override
    public boolean guarda(Usuario u) {
        boolean guardado = false;
        try {
            u = em.merge(u);
            guardado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return guardado;
    }

    @Override
    public boolean borra(Integer id) {
        boolean borrado = false;
        try {
            Usuario u = null;
            u = em.find(Usuario.class, id);
            em.remove(u);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return borrado;
}

}