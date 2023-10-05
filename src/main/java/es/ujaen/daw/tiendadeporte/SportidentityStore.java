package es.ujaen.daw.tiendadeporte;
import java.util.Set;

import es.ujaen.daw.tiendadeporte.usuarios.Usuario;
import es.ujaen.daw.tiendadeporte.usuarios.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.logging.Logger;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
//import jakarta.faces.context.ExternalContext console;

@ApplicationScoped
public class SportidentityStore implements IdentityStore {
    private static final Logger logger = Logger.getLogger(SportidentityStore.class.getName());

    @Inject @DAOJpa
    private UsuarioDAO usuarioDAO;

    @Inject Preferencias preferencias;



    public SportidentityStore() {

    }


    public CredentialValidationResult validate (UsernamePasswordCredential usernamePasswordCredential ) {


        //Recuperar credenciales proporcionadas por el servidor
        String username = usernamePasswordCredential.getCaller();
        //console.log(username);

        String password = usernamePasswordCredential.getPasswordAsString();

        //Ejemplo simple de verificación de credenciales
        Usuario usuario= usuarioDAO.buscaEmail(username);

        if (usuario != null && usuario.getClave().equals(password)) {

            preferencias.setUsuario(usuario);
        //Autenticación completada, obtener los roles del usuario...
            String rol="USUARIOS";
            if(usuario.getAdministrador()==true){
                rol="ADMINISTRADORES";
            }

            Set<String> roles = new HashSet<>(Arrays.asList(rol));
        //Pasar datos del usuario al servidor
            return new CredentialValidationResult(username, roles);
        }

        return INVALID_RESULT; //Autenticación inválida
    }


}