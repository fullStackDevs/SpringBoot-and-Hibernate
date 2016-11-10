package com.service;

import com.dto.StudentDTO;
import com.entity.Student;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Collection<StudentDTO> getAll(){
        Collection<Student> resutls = studentRepository.getAll();
        return studentListToStudentDTOlist(resutls);
    }

    public Student getStudentById(int id){
        return studentRepository.getStudentById(id);
    }

    public void removeStudentById(int id) {
        if(getStudentById(id) != null){
            studentRepository.removeStudentById(id);
        }
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    public void insertStudent(StudentDTO studentDTO) {
        Student student = studentDTOtoStudent(studentDTO);
        studentRepository.insertStudent(student);
    }

    private Student studentDTOtoStudent(StudentDTO studentDTO) {
        Student student = new Student();
        // not set because it will be generated in the db
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setCourses(studentDTO.getCourses());
        return student;
    }

    private StudentDTO studentToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setCourses(student.getCourses());
        return studentDTO;
    }

    private Collection<StudentDTO> studentListToStudentDTOlist(Collection<Student> students){
        List<StudentDTO> studentDTOset = new ArrayList<StudentDTO>();
        StudentDTO studentDTO = null;
        for(Student st:students){
            studentDTO = studentToStudentDTO(st);
            studentDTOset.add(studentDTO);
        }
        return studentDTOset;

    }
}
