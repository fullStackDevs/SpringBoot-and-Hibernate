package com.repository;

import com.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {

    @PersistenceContext
    EntityManager em;

    public List<Course> getCourses(){
        TypedQuery<Course> query = em.createNamedQuery(Course.FIND_ALL, Course.class);

        return query.getResultList();

    }
}
