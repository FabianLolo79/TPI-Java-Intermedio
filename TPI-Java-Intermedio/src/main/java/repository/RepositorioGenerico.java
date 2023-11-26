package repository;

import java.util.Set;

import entity.Servicio;

/*
 * Interfaz de Repositorio generica que Puede recibir varios tipos 
 * de objetos en las implementaciones para las diferentes entidades 
 * se debe castear el objeto a la entidad que se quiere implementar.  
 * La idea es no crear una interfase para cada entidad, solo sus implementaciones.
 * Queda resolver tambien el tema de verificar que sea una instancia 
 * if(obj instanceof Servicio) 
 * ya que el metodo puede recibir cualquier tipo de objetos.
 * Los metodos eliminar y traer por id siguen recibiendo por parametro un entero
 * ya que todas las tablas poseen un int como ID, tambien se podria trabajar con 
 * el objeto, castearlo y obtener el id del mismo.
 */

public interface RepositorioGenerico {
    void agregar(Object objeto);
    void actualizar(Object objeto);
    void eliminar(int id);
    public Object traerPorID(int id);
    public Set<Object> traerLista();
}
