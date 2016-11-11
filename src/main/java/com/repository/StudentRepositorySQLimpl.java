package com.repository;

import com.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;


@Repository
@Qualifier("studentRepositorySQLimpl")
@Transactional
public class StudentRepositorySQLimpl implements StudentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Collection<Student> getAll(){
        TypedQuery<Student> query = em.createNamedQuery(Student.FIND_ALL, Student.class);
        Collection<Student> results = query.getResultList();

        //return query.getResultList();
        return results;
    }

    @Override
    public Student getStudentById(int id) {
        TypedQuery<Student> query = em.createNamedQuery(Student.FIND_BY_ID, Student.class);
        query.setParameter("1", id);
        return query.getSingleResult();
    }

    @Override
    public void removeStudentById(int id) {
       //Student student = getStudentById(id);
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

    @Override
    public void updateStudent(Student student) {
        em.merge(student);
    }

    @Override
    public void insertStudent(Student student) {
        em.persist(student);
    }
}
