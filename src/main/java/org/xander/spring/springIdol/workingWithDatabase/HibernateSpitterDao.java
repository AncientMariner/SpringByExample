package org.xander.spring.springIdol.workingWithDatabase;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class HibernateSpitterDao implements SpitterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);
    }
}
