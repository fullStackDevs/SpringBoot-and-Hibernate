package com.repository;


import com.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;

//@Repository("studentRepository")
@Repository
@Qualifier("studentRepositoryDAOimpl")
@Transactional
public class StudentRepositoryDAOimpl implements StudentRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Collection<Student> getAll() {
        Collection<Student> dummyResults = new ArrayList<Student>();
        Student stud = new Student();
        stud.setFirstName("Ivan");
        stud.setLastName("Taie");
        dummyResults.add(stud);
        return dummyResults;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
