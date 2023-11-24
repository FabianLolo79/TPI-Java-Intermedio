package dao;

import javax.persistence.EntityManager;

public interface DAO {
    EntityManager getEntityManager();
}
