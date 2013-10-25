package org.xander.spring.springIdol.workingWithDatabase.orm;

import java.util.List;

public interface CourseDao {
    void store(CourseAnnotated course);
    void delete(Long courseId);
    CourseAnnotated findById(Long courseId);
    List<CourseAnnotated> findAll();
}

