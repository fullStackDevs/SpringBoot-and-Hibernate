package com.repository;

import com.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;



@Repository
@Transactional
public class StudentRepository {

    @PersistenceContext
    EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Student> getAll(){
        TypedQuery<Student> query = em.createNamedQuery(Student.FIND_ALL, Student.class);
        Collection<Student> results = query.getResultList();

        //return query.getResultList();
        return results;
    }

    public Student getStudentById(int id) {
        TypedQuery<Student> query = em.createNamedQuery(Student.FIND_BY_ID, Student.class);
        query.setParameter("1", id);
        return query.getSingleResult();
    }

    public void removeStudentById(int id) {
       //Student student = getStudentById(id);
        Student student = em.find(Student.class, id);
        em.remove(student);
    }
}
