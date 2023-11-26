package repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;

import dao.DAO;

import entity.Servicio;

public class JpaServicioRepositorio implements ServicioRepositorio{

    private DAO dao;

    @Override
    public void agregarServicio(Servicio servicio) {

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
    public void actualizarServicio(Servicio servicio) {
        
        EntityManager em = dao.getEntityManager();

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
    public void eliminarServicio(int id) {
        
        EntityManager em = dao.getEntityManager();

        try {

            em.getTransaction().begin();
            em.remove(id);
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
    public Servicio traerServicioPorID(int id) {
        
        System.out.println("Se trae servicio por id");
        EntityManager em = dao.getEntityManager();

        try {
            return em.find(Servicio.class, id);
        } 
        finally{
            em.close();
        }
    }

    @Override
    public Set<Servicio> listaServicios() {
        
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
