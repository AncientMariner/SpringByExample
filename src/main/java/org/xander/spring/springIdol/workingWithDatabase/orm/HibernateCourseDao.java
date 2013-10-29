package org.xander.spring.springIdol.workingWithDatabase.orm;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//if you want the Hibernate exceptions to be
//translated into Spring’s DataAccessException for consistent exception handling, you have to apply the
//@Repository annotation to your DAO class that requires exception translation
@Repository("courseDao")
public class HibernateCourseDao implements CourseDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateCourseDao() {
//        By default, it loads hibernate.cfg.xml from the classpath root when you call the
//        configure() method.
        //simple xml-driven way
//        Configuration configuration = new Configuration().configure();
//        sessionFactory = configuration.buildSessionFactory();

        // For JPA annotation
//        Configuration configuration = new Configuration().configure();
//        sessionFactory = configuration.buildSessionFactory();

    }

    @Transactional
    public void store(CourseAnnotated course) {
        sessionFactory.getCurrentSession().saveOrUpdate(course);
    }

    @Transactional
    public void delete(Long courseId) {
        CourseAnnotated course = (CourseAnnotated) sessionFactory.getCurrentSession().get(
                CourseAnnotated.class, courseId);
        sessionFactory.getCurrentSession().delete(course);
    }
    @Transactional(readOnly = true)
    public CourseAnnotated findById(Long courseId) {
        return (CourseAnnotated) sessionFactory.getCurrentSession().get(
                CourseAnnotated.class, courseId);
    }
    @Transactional(readOnly = true)
    public List<CourseAnnotated> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from CourseAnnotated");
        return query.list();
    }

}
