package org.xander.spring.springIdol.workingWithDatabase.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        CourseDao courseDao = new HibernateCourseDao();
//
//        Course course = new Course();
//        course.setTitle("Core Spring");
//        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
//        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
//        course.setFee(1000);
//        courseDao.store(course);
//
//        List<Course> courses = courseDao.findAll();
//        Long courseId = courses.get(0).getId();
//        course = courseDao.findById(courseId);
//
//        System.out.println("Course Title: " + course.getTitle());
//        System.out.println("Begin Date: " + course.getBeginDate());
//        System.out.println("End Date: " + course.getEndDate());
//        System.out.println("Fee: " + course.getFee());
//
//        courseDao.delete(courseId);


//        CourseDao courseDao = new JpaCourseDao();
//        CourseAnnotated course = new CourseAnnotated();
//        course.setTitle("Core Spring");
//        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
//        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
//        course.setFee(1000);
//        courseDao.store(course);
//
//        List<CourseAnnotated> courses = courseDao.findAll();
//        Long courseId = courses.get(0).getId();
//        course = courseDao.findById(courseId);
//
//        System.out.println("Course Title: " + course.getTitle());
//        System.out.println("Begin Date: " + course.getBeginDate());
//        System.out.println("End Date: " + course.getEndDate());
//        System.out.println("Fee: " + course.getFee());
//
//        courseDao.delete(courseId);


//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("org/xander/spring/springIdol/workingWithDatabase/orm/beans-hibernate.xml");

        ApplicationContext context = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/workingWithDatabase/orm/beans-jpa.xml");


        CourseDao courseDao = (CourseDao) context.getBean("courseDao");
        CourseAnnotated course = new CourseAnnotated();
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(1000);
        courseDao.store(course);

        List<CourseAnnotated> courses = courseDao.findAll();
        Long courseId = courses.get(0).getId();
        course = courseDao.findById(courseId);

        System.out.println("Course Title: " + course.getTitle());
        System.out.println("Begin Date: " + course.getBeginDate());
        System.out.println("End Date: " + course.getEndDate());
        System.out.println("Fee: " + course.getFee());

        courseDao.delete(courseId);
    }
}
