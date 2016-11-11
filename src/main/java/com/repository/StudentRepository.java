package com.repository;

import com.entity.Student;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * Created by pbirzu on 11/11/2016.
 */
public interface StudentRepository {
    void setEm(EntityManager em);

    Collection<Student> getAll();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
