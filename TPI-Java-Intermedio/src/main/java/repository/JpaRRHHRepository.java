package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Incidente;
import repository.dao.DAO;

public class JpaRRHHRepository implements RRHHRepositorio{

    private DAO dao;

    public JpaRRHHRepository(DAO dao){
        this.dao = dao;
    }

    @Override
    public List<Incidente> reporteDiarioDeIncidentes() {
        EntityManager em = dao.getEntityManager();

        try {
            Query q = em.createQuery("Select e.tecnicoAsignado from incidentes e where"
                    +"datediff(now(), e.createat) = 0)"
                    +"orderby count(e) desc", Incidente.class);
            return (List<Incidente>)q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    
}
