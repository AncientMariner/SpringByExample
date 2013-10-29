package org.xander.spring.springIdol.workingWithDatabase.orm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HibernateCourseDao implements CourseDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    @Transactional
    public void store(CourseAnnotated course) {
        hibernateTemplate.saveOrUpdate(course);
    }
    @Transactional
    public void delete(Long courseId) {
        CourseAnnotated course = (CourseAnnotated) hibernateTemplate.get(CourseAnnotated.class, courseId);
        hibernateTemplate.delete(course);
    }
    @Transactional(readOnly = true)
    public CourseAnnotated findById(Long courseId) {
        return (CourseAnnotated) hibernateTemplate.get(CourseAnnotated.class, courseId);
    }
    @Transactional(readOnly = true)
    public List<CourseAnnotated> findAll() {
        return hibernateTemplate.find("from CourseAnnotated");
    }



    public HibernateCourseDao() {
//        By default, it loads hibernate.cfg.xml from the classpath root when you call the
//        configure() method.
        //simple xml-driven way
//        Configuration configuration = new Configuration().configure();
//        sessionFactory = configuration.buildSessionFactory();

        // For JPA annotation
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();

    }

//    public void store(CourseAnnotated course) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.getTransaction();
//        try {
//            tx.begin();
//            session.saveOrUpdate(course);
//            tx.commit();
//        } catch (RuntimeException e) {
//            // when database is not yet created - Exception in thread "main"
//            // org.hibernate.TransactionException:
//            // Transaction not successfully started is thrown !!!
//            tx.rollback();
//            throw e;
//        } finally {
//            session.close();
//        }
//    }
//    public void delete(Long courseId) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.getTransaction();
//        try {
//            tx.begin();
//            CourseAnnotated course = (CourseAnnotated) session.get(CourseAnnotated.class, courseId);
//            session.delete(course);
//            tx.commit();
//        } catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        } finally {
//            session.close();
//        }
//    }
//    public CourseAnnotated findById(Long courseId) {
//        Session session = sessionFactory.openSession();
//        try {
//            return (CourseAnnotated) session.get(CourseAnnotated.class, courseId);
//        } finally {
//            session.close();
//        }
//    }
//    public List<CourseAnnotated> findAll() {
//        Session session = sessionFactory.openSession();
//        try {
//            Query query = session.createQuery("from CourseAnnotated ");
//            return query.list();
//        } finally {
//            session.close();
//        }
//    }
}
