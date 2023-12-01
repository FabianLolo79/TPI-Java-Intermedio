package repository;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import entity.Empleado;
import entity.Especialidad;
import entity.Incidente;
import entity.Servicio;
import entity.Status;
import repository.dao.DAO;

public class JpaIncidenteRepository implements IncidenteRepository, RepositorioGenerico {

    private DAO dao;

    public JpaIncidenteRepository (DAO dao){

        this.dao = dao;

    }

    @Override
    public Empleado tecnicoMayorIncidentesResueltos(Status estado, int dias) {
        EntityManager em = dao.getEntityManager();

        try {
            
            Query q = em.createQuery("Select e.tecnicoAsignado from incidentes e where"
                    +"datediff(now(), e.createat) <= :dias and e.status = :estado)"
                    +"groupby e.tecnicoAsignado"
                    +"orderby count(e) desc", Empleado.class);
                q.setParameter("dias", dias);
                q.setParameter("estado", estado.RESUELTO);
                q.setMaxResults(1);
                return (Empleado) q.getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }

    @Override
    public Empleado tecnicoMayorIncidentesPorEspecialidad(Especialidad especialidad, int dias, Status estado) {
        EntityManager em = dao.getEntityManager();

        try {
            
            Query q = em.createQuery("Select i.tecnicoasignado from incidentes i where"
                    +"datediff(now(), i.createat) <= :dias and i.status = :estado)"
                    +"join i.especialidades e"
                    +"where e.especialidad = :app"
                    +"groupby e.tecnicoAsignado"
                    +"orderby count(e) desc", Empleado.class);
                q.setParameter("dias", dias);
                q.setParameter("estado", estado.RESUELTO);
                q.setParameter("app", especialidad.getEspecialidad());
                q.setMaxResults(1);
                return (Empleado) q.getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }

    @Override
    public Empleado tecnicoMejorTiempoDeResolucionIncidentes() {
       EntityManager em = this.dao.getEntityManager();

       try {
            Query q = em.createQuery("Select e.tecnicoasignado"
            +"from incidentes e where e.status = :estado"
            +"groupby e.resolutiontime"
            +"orderby count(e) asc", Empleado.class);
            q.setParameter("estado", Status.RESUELTO);
            q.setMaxResults(1);
            return (Empleado) q.getSingleResult();
       } catch (Exception e) {
        e.printStackTrace();
       }
       finally{
        em.close();
       }
    }

    @Override
    public void agregar(Object objIncidente) {
        EntityManager em = this.dao.getEntityManager();
        Incidente persistirIncidente = (Incidente) objIncidente;

        try {
            em.getTransaction().begin();;
            em.persist(persistirIncidente);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Incidente Agregado.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("No se pudo agregar el Incidente.");
                e.printStackTrace();
            }
        }
        finally{
            em.close();
        }
    }

    @Override
    public Object traerPorID(int id) {
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
    public Set<Object> traerLista() {
           EntityManager em = dao.getEntityManager();

        try {
            return em.createQuery("Select * from incidentes", Incidente.class)
            .getResultStream()
            .collect(Collectors.toSet());
        }
        finally{
            em.close();
        }
    }
    }

    @Override
    public void actualizar(Object objIncidente) {
        EntityManager em = this.dao.getEntityManager();
        Incidente persistirIncidente = (Incidente) objIncidente;

        try {
            em.getTransaction().begin();;
            em.merge(persistirIncidente);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Incidente Actualizado.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("No se pudo actualizar el Incidente.");
                e.printStackTrace();
            }
        }
        finally{
            em.close();
            em.flush();
        }
    }

    @Override
    public void eliminar(Object objIncidente) {
        EntityManager em = this.dao.getEntityManager();
        Incidente persistirIncidente = (Incidente) objIncidente;

        try {
            em.getTransaction().begin();;
            em.remove(persistirIncidente);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Incidente Eliminado.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("No se pudo eliminar el Incidente.");
                e.printStackTrace();
            }
        }
        finally{
            em.close();
        }
    }

    @Override
    public void altaAppIncidente(Especialidad app, int idIncidente, int tiempoEstimadoResolucion) {
        EntityManager em = dao.getEntityManager();
        Incidente incidente;

        try {
            incidente = em.find(Incidente.class, idIncidente);
            incidente.getAplicaciones().add(app);
            int colchon = incidente.getResolutionTime()+tiempoEstimadoResolucion;
            incidente.setResolutionTime(colchon);
            em.getTransaction().begin();
            em.merge(incidente);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Se dio de alta nuevo problema en el incidente "+idIncidente
            +"Se añadio"+tiempoEstimadoResolucion+" horas ya que el incidente es complejo");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }
    
}
