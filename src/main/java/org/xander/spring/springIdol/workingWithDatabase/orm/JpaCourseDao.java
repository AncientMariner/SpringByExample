package org.xander.spring.springIdol.workingWithDatabase.orm;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository("courseDao")
public class JpaCourseDao implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


    @Transactional
    public void store(CourseAnnotated course) {
        entityManager.merge(course);
    }

    @Transactional
    public void delete(Long courseId) {
        CourseAnnotated course = entityManager.find(CourseAnnotated.class, courseId);
        entityManager.remove(course);
    }

    @Transactional(readOnly = true)
    public CourseAnnotated findById(Long courseId) {
        return entityManager.find(CourseAnnotated.class, courseId);
    }

    @Transactional(readOnly = true)
    public List<CourseAnnotated> findAll() {
        Query query = entityManager.createQuery("from CourseAnnotated");
        return query.getResultList();
    }


}
