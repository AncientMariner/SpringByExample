package org.xander.spring.springIdol.workingWithDatabase.orm;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JpaCourseDao extends JpaDaoSupport implements CourseDao{
//    private EntityManagerFactory entityManagerFactory;
//    public JpaCourseDao() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("course");
//    }


//    private JpaTemplate jpaTemplate;
//    public void setJpaTemplate(JpaTemplate jpaTemplate) {
//        this.jpaTemplate = jpaTemplate;
//    }
@Transactional
public void store(CourseAnnotated course) {
    getJpaTemplate().merge(course);
}
    @Transactional
    public void delete(Long courseId) {
        CourseAnnotated course = getJpaTemplate().find(CourseAnnotated.class, courseId);
        getJpaTemplate().remove(course);
    }
    @Transactional(readOnly = true)
    public CourseAnnotated findById(Long courseId) {
        return getJpaTemplate().find(CourseAnnotated.class, courseId);
    }
    @Transactional(readOnly = true)
    public List<CourseAnnotated> findAll() {
        return getJpaTemplate().find("from CourseAnnotated");
    }



//
//    public void setEntityManagerFactory(
//            EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }

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
