package com.repository;

import com.entity.Course;
import com.entity.Student;
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

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Course> getCourses(){
        TypedQuery<Course> query = em.createNamedQuery(Course.FIND_ALL, Course.class);
        return query.getResultList();
    }

    public Course getCourse(int courseID){
        TypedQuery<Course> query = em.createNamedQuery(Course.FIND_BY_ID, Course.class);
        query.setParameter("1", courseID);
        Course course = query.getSingleResult();
        return course;
    }


    //It doesn't work
//    public List<Student> getEnrolledStudents(int courseID){
//        TypedQuery<Student> query = em.createNamedQuery(Course.FIND_ENROLLED_STUDENTS, Student.class);
//        query.setParameter("1", courseID);
//        List<Student> resutls = query.getResultList();
//        return resutls;
//    }
}
