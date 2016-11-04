package com.repository;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Student> getAll(){
        TypedQuery query = em.createNamedQuery(Student.FIND_ALL, Student.class);
        Collection<Student> results = query.getResultList();

        //return query.getResultList();
        return results;
    }
}
