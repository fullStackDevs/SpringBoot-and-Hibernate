package com.service;

import com.entity.Student;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Collection<Student> getAll(){
        Collection<Student> resutls = studentRepository.getAll();
        return resutls;
    }

    public Student getStudentById(int id){
        return studentRepository.getStudentById(id);
    }

    public void removeStudentById(int id) {
        if(getStudentById(id) != null){
            studentRepository.removeStudentById(id);
        }
    }

    public void createStudent(Student student) {
            studentRepository.createStudent(student);
    }
}
