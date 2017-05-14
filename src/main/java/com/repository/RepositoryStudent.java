package com.repository;

import com.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andu on 12.05.2017.
 */
public class RepositoryStudent implements IRepository<Student> {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static EntityManagerFactory factory;

    @Override
    public void add(Student entity) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }

    @Override
    public List<Student> getAll() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery("SELECT st FROM Student st");
        List<Student> result = query.getResultList();
        em.getTransaction().commit();

        em.close();
        factory.close();

        return result;
    }

    public List<String> getNoteStudent(int entity)
    {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("select prof.materie,nt.valoareNota,nt.comentariu from Student st inner join Notare nt on nt.numarMatricol=st.numarMatricol inner join Profesor prof on prof.idProfesor = nt.idProfesor and st.numarMatricol=?1").setParameter(1,entity);

        List<Object[]> note = query.getResultList();

        List<String> result = new LinkedList<>();

        for(Object[] o : note)
        {
            String line = o[0].toString() + "|" + o[1].toString() + "|" + o[2].toString();
            result.add(line);
        }

        em.close();
        factory.close();

        return result;
    }

    @Override
    public Student getOne(int id) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Student st = em.find(Student.class, id);

        em.close();
        factory.close();

        return st;
    }

    public Student getOne(String username, String password) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT st from Student st where st.usernameStudent = ?1 and st.parolaStudent = ?2");
        query.setParameter(1, username);
        query.setParameter(2, password);

        Student st = new Student();

        if (query.getResultList().size() > 0)
            st = (Student) (query.getResultList().get(0));
        else
            st = null;

        em.close();
        factory.close();

        return st;
    }

    @Override
    public void update(int id, Student newEntity) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Student st = em.find(Student.class, id);
        st.setNumeStudent(newEntity.getNumeStudent());
        st.setPrenumeStudent(newEntity.getPrenumeStudent());
        st.setUsernameStudent(newEntity.getUsernameStudent());
        st.setParolaStudent(newEntity.getParolaStudent());
        em.merge(st);

        em.getTransaction().commit();

        em.close();
        factory.close();
    }

    @Override
    public void delete(Student entity) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Student st = em.find(Student.class, entity.getNumarMatricol());
        em.remove(st);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}
