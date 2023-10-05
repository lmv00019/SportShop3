package es.ujaen.daw.tiendadeporte.articulos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Articulo implements Serializable {
    @Id
    @Min(value = 1, message = "El id no puede ser menor que 1")
    @Max(value = 1000, message = "El id no puede ser mayor que 1000")
    private int id;

    @Size(min=2, max=50, message="Longitud del nombre entre {min} y {max} caracteres")
    private String nombre;

    @Size(min=2, max=50, message="Longitud de la categoria entre {min} y {max} caracteres")
    private String categoria;

    @Min(value = 1, message = "El precio no puede ser por debajo de 1")
    @Max(value = 1000, message = "El precio no puede ser mayor de 1000")
    private float precio;

    @Min(value = 1, message = "Las unidades no pueden ser por debajo de 1")
    @Max(value = 100, message = "Las unidades no pueden ser mayor de 100")
    private int unidades;

    @Size(min=2, max=100, message="Longitud del nombre entre {min} y {max} caracteres")
    private String imagen;

    @Size(min=1, max=4, message="Longitud de la talla entre {min} y {max} caracteres")
    private String talla;
    @Size(min=2, max=100, message="Longitud del nombre entre {min} y {max} caracteres")
    private String visualiza;

    public Articulo(){}


    public Articulo(int id, String nombre, String categoria, float precio, int unidades, String imagen, String talla, String visualiza) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.unidades = unidades;
        this.imagen = imagen;
        this.talla = talla;
        this.visualiza = visualiza;
    }



    public Articulo(Articulo articulo){
        this.id = articulo.id;
        this.nombre = articulo.nombre;
        this.categoria = articulo.categoria;
        this.precio = articulo.precio;
        this.unidades = articulo.unidades;
        this.imagen = articulo.imagen;
        this.talla = articulo.talla;
        this.visualiza = articulo.visualiza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", unidades=" + unidades +
                ", imagen='" + imagen + '\'' +
                ", visualiza='" + visualiza + '\'' +
                '}';
    }

    public String getVisualiza() {
        return visualiza;
    }

    public void setVisualiza(String visualiza) {
        this.visualiza = visualiza;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }


}
