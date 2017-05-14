package com.repository;

import com.domain.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andu on 12.05.2017.
 */
public class RepositoryProfesor implements IRepository<Profesor> {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static EntityManagerFactory factory;

    @Override
    public void add(Profesor entity) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }

    @Override
    public List<Profesor> getAll() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery("SELECT prof FROM Profesor prof");
        List<Profesor> result = query.getResultList();
        em.getTransaction().commit();

        em.close();
        factory.close();

        return result;
    }

    @Override
    public Profesor getOne(int id) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Profesor st = em.find(Profesor.class, id);

        em.close();
        factory.close();

        return st;
    }

    public Profesor getOne(String username, String password) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT st from Profesor st where st.usernameProfesor = ?1 and st.parolaProfesor = ?2");
        query.setParameter(1, username);
        query.setParameter(2, password);

        Profesor st = new Profesor();

        if (query.getResultList().size() > 0)
            st = (Profesor) (query.getResultList().get(0));
        else
            st = null;

        em.close();
        factory.close();

        return st;
    }

    public List<String> getNoteProfesor(int entity)
    {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("select st.numeStudent ,st.prenumeStudent , nt.valoareNota , prof.materie from Student st inner join Notare nt on nt.numarMatricol=st.numarMatricol inner join Profesor prof on prof.idProfesor = nt.idProfesor and prof.idProfesor=?1").setParameter(1,entity);

        List<Object[]> note = query.getResultList();

        List<String> result = new LinkedList<>();

        for(Object[] o : note)
        {
            String line = o[0].toString() + "|" + o[1].toString() + "|" + o[2].toString() + "|" + o[3].toString();
            result.add(line);
        }

        em.close();
        factory.close();

        return result;
    }

    @Override
    public void update(int id, Profesor newEntity) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Profesor st = em.find(Profesor.class, id);
        st.setNumeProfesor(newEntity.getNumeProfesor());
        st.setPrenumeProfesor(newEntity.getPrenumeProfesor());
        st.setUsernameProfesor(newEntity.getUsernameProfesor());
        st.setParolaProfesor(newEntity.getParolaProfesor());
        em.merge(st);

        em.getTransaction().commit();

        em.close();
        factory.close();
    }

    @Override
    public void delete(Profesor entity) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Profesor st = em.find(Profesor.class, entity.getIdProfesor());
        em.remove(st);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}
