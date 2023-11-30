package repository;

import java.util.Set;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import entity.Incidente;
import entity.Servicio;
import repository.dao.DAO;

public class JpaServicioRepositorio implements RepositorioGenerico{

    private DAO dao;

    @Override
    public void agregar(Object objServicio) {

        Servicio servicio = (Servicio)objServicio;

        EntityManager em = dao.getEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(servicio);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Servicio agregado");
        
        } catch (Exception e) {

            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
                System.out.println("No se pudo agregar servicio.");
                e.printStackTrace();
            }

        }
        finally{
            em.close();
        }
    }

    @Override
    public void actualizar(Object objServicio) {
        
        EntityManager em = dao.getEntityManager();
        Servicio servicio = (Servicio) objServicio;

        try {
            em.getTransaction().begin();
            em.merge(servicio);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Servicio actualizado");
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
                System.out.println("No se pudo actualizar el servicio.");
                e.printStackTrace();
            }
        }
        finally{
            em.close();
            em.flush();
        }
    }

    @Override
    public void eliminar(Object objServicio) {
        
        EntityManager em = dao.getEntityManager();
        Servicio servicio = (Servicio)objServicio;
        try {

            em.getTransaction().begin();
            em.remove(servicio);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Servicio eliminado");
        
        } catch (Exception e) {
        
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
                System.out.println("No se pudo eliminar servicio.");
                e.printStackTrace();
            }

        }
        finally{
            em.close();
        }
    }

    @Override
    public Object traerPorID(int id) {
        
        System.out.println("Se trae incidente por id");
        EntityManager em = dao.getEntityManager();

        try {
            return em.find(Incidente.class, id);
        } 
        finally{
            em.close();
        }
    }

    @Override
    public Set<Object> traerLista() {
        
        EntityManager em = dao.getEntityManager();

        try {
            return em.createQuery("Select * from servicios", Servicio.class)
            .getResultStream()
            .collect(Collectors.toSet());
        }
        finally{
            em.close();
        }
    }
    
}
