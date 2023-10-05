package es.ujaen.daw.tiendadeporte.usuarios;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity      //JPA annotations
//@Table(name="Usuario")
public class Usuario implements Serializable {

           //JPA annotations
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremental

    private Integer id;

    @Size(min = 4, max = 25, message = "La longitud ${validatedValue} debe estar entre {min} y {max} caracteres")
    private String nombre;
    @Pattern(regexp = "\\d{7,8}(-?[a-zA-Z])?", message = "El D.N.I debe tener 9 digitos y unaa letra en mayus o minus")
    private String dni;

    private boolean administrador;

    @Id
    private String email;

    private String clave;




    public Usuario() {

        id = 0;
        nombre = "";
        dni="";
        administrador=false;
        email="";
        clave="";

    }

    public Usuario(Integer id, String nombre, String dni, boolean administrador, String email, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.administrador = administrador;
        this.email = email;
        this.clave= clave;

    }

    /**
     * Copy constructor
     */
    public Usuario(Usuario u) {
        this.id = u.id;
        this.nombre = u.nombre;
        this.dni = u.dni;
        this.administrador = u.administrador;
        this.email = u.email;
        this.clave= u.clave;

    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the administrador
     */
    public boolean getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "Usuario[ id=" + id +"]";
}

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}






























































































