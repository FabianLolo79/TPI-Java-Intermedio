package repository;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import entity.Especialidad;

import repository.dao.DAO;

public class jpaEspecialidadRepositorio implements RepositorioGenerico {

    private DAO dao;

    @Override
    public void agregar(Object objEspecialidad) {

        EntityManager em = dao.getEntityManager();
        Especialidad especialidad = (Especialidad) objEspecialidad;

        try {

            em.getTransaction().begin();
            em.persist(especialidad);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Especialidad agregada");
        
        } catch (Exception e) {

            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
                System.out.println("No se pudo agregar la Especialidad.");
                e.printStackTrace();
            }

        }
        finally{
            em.close();
        }
    }

    @Override
    public void actualizar(Object objEspecialidad) {
        EntityManager em = dao.getEntityManager();
        Especialidad especialidad = (Especialidad) objEspecialidad;

        try {

            em.getTransaction().begin();
            em.merge(especialidad);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Especialidad actualizada");
        
        } catch (Exception e) {

            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
                System.out.println("No se pudo actualizar la Especialidad.");
                e.printStackTrace();
            }

        }
        finally{
            em.close();
        }
    }

    @Override
    public void eliminar(Object objEspecialidad) {
        EntityManager em = dao.getEntityManager();
        Especialidad especialidad = (Especialidad)objEspecialidad;
        try {

            em.getTransaction().begin();
            em.remove(especialidad);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Especialidad eliminada");
        
        } catch (Exception e) {
        
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
                System.out.println("No se pudo eliminar la Especialidad.");
                e.printStackTrace();
            }

        }
        finally{
            em.close();
        }
    }

    @Override
    public Object traerPorID(int id) {
        System.out.println("Se trae Especialidad por id");
        EntityManager em = dao.getEntityManager();

        try {
            return em.find(Especialidad.class, id);
        } 
        finally{
            em.close();
        }
    }

    @Override
    public Set<Object> traerLista() {
        
        EntityManager em = dao.getEntityManager();

        try {
            return em.createQuery("Select * from especialidades", Especialidad.class)
            .getResultStream()
            .collect(Collectors.toSet());
        }
        finally{
            em.close();
        }
    }
    
}
