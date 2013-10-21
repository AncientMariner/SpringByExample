package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("spitterDao")
@Transactional
public class JpaSpitterDao implements SpitterDAO {
    private static final String RECENT_SPITTLES = "SELECT s FROM Spittle s";
    private static final String ALL_SPITTERS = "SELECT s FROM Spitter s";
    private static final String SPITTER_FOR_USERNAME = "SELECT s FROM Spitter s WHERE s.username = :username";
    private static final String SPITTLES_BY_USERNAME = "SELECT s FROM Spittle s WHERE s.spitter.username = :username";

    @PersistenceContext
    private EntityManager em;

    public void addSpitter(Spitter spitter) {
        em.persist(spitter);
    }

    public Spitter getSpitterById(long id) {
        return em.find(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
        em.merge(spitter);
    }
}
