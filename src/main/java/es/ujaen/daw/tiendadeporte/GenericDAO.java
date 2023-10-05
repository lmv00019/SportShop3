package es.ujaen.daw.tiendadeporte;

import java.util.List;

public interface GenericDAO<T,K> {

    public T buscaId(K id);
    public List<T> buscaTodos();
    public boolean crea(T u);
    public boolean guarda(T u);
    public boolean borra(K id);
}