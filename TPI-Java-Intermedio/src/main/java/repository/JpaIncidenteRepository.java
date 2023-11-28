package repository;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import dao.DAO;
import entity.Empleado;
import entity.Especialidad;
import entity.Status;

public class JpaIncidenteRepository implements IncidenteRepository {

    private DAO dao;

    public JpaIncidenteRepository (DAO dao){

        this.dao = dao;

    }

    @Override
    public Empleado tecnicoMayorIncidentesResueltos(Status estado, int dias) {
        EntityManager em = dao.getEntityManager();

        try {
            
            Query q = em.createQuery("Select e tecnicoAsignado from incidentes e where"
                    +"datediff(now(), e.createat) <= :dias and status = :estado)"
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
        return null;
    }

    @Override
    public Empleado tecnicoMayorIncidentesPorEspecialidad(Especialidad especialidad, int dias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tecnicoMayorIncidentesPorEspecialidad'");
    }

    @Override
    public Empleado tecnicoMejorTiempoDeResolucionIncidentes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tecnicoMejorTiempoDeResolucionIncidentes'");
    }
    
}
