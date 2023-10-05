package es.ujaen.daw.tiendadeporte.usuarios;


import es.ujaen.daw.tiendadeporte.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario,Integer> {
    //Declare here specific methods for EntityDAO
    public Usuario buscaDni(String dni);
    public Usuario buscaEmail(String email);
}


