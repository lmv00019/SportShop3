package es.ujaen.daw.tiendadeporte;

import jakarta.faces.annotation.FacesConfig;
import jakarta.enterprise.context.ApplicationScoped;
import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;

/*
@EmbeddedIdentityStoreDefinition({
        @Credentials(callerName = "admin", password = "secret1", groups = {"ADMINISTRADORES"}),
        @Credentials(callerName = "user", password = "secret2", groups = {"USUARIOS"})

})*/

@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "/login.xhtml?error",
                useForwardToLogin = false
        )
)

//@BasicAuthenticationMechanismDefinition( realmName = "Catálogo de articulos" )
@ApplicationScoped
@FacesConfig
public class AppConfig {
}