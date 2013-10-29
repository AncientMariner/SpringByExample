package org.xander.spring.springIdol.workingWithDatabase.orm;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaCourseDao implements CourseDao{
    private EntityManagerFactory entityManagerFactory;
//    public JpaCourseDao() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("course");
//    }


    private JpaTemplate jpaTemplate;
    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }
    @Transactional
    public void store(CourseAnnotated course) {
        jpaTemplate.merge(course);
    }
    @Transactional
    public void delete(Long courseId) {
        CourseAnnotated course = jpaTemplate.find(CourseAnnotated.class, courseId);
        jpaTemplate.remove(course);
    }
    @Transactional(readOnly = true)
    public CourseAnnotated findById(Long courseId) {
        return jpaTemplate.find(CourseAnnotated.class, courseId);
    }

    public List<CourseAnnotated> findAll() {
        return jpaTemplate.find("select course from CourseAnnotated course");
    }



    public void setEntityManagerFactory(
            EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

//    public void store(CourseAnnotated course) {
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        try {
//            tx.begin();
//            manager.merge(course);
//            tx.commit();
//        } catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        } finally {
//            manager.close();
//        }
//    }
//    public void delete(Long courseId) {
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        try {
//            tx.begin();
//            CourseAnnotated course = manager.find(CourseAnnotated.class, courseId);
//            manager.remove(course);
//            tx.commit();
//        } catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        } finally {
//            manager.close();
//        }
//    }
//    public CourseAnnotated findById(Long courseId) {
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        try {
//            return manager.find(CourseAnnotated.class, courseId);
//        } finally {
//            manager.close();
//        }
//    }
//    public List<CourseAnnotated> findAll() {
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        try {
//            Query query = manager.createQuery(
//                    "select course from CourseAnnotated course");
//            return query.getResultList();
//        } finally {
//            manager.close();
//        }
//    }

}
