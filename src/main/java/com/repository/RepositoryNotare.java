package com.repository;


import com.domain.Notare;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Andu on 13.05.2017.
 */
public class RepositoryNotare implements IRepository<Notare> {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static EntityManagerFactory factory;

    @Override
    public void add(Notare entity) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }

    @Override
    public List<Notare> getAll() {
        return null;
    }

    @Override
    public Notare getOne(int id) {
        return null;
    }

    @Override
    public void update(int id, Notare newEntity) {

    }

    @Override
    public void delete(Notare entity) {

    }
}
