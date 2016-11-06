package com.controller;

import com.entity.Course;
import com.entity.Student;
import com.service.CourseService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class MainController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/greeting")
    public String getGreeting(){
        return "HelloWorld";
    }

    @RequestMapping(value = "/courses")
    public List<Course> testCoursesList(){
       return courseService.getCourses();

    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        Collection<Student> results = studentService.getAll();
        System.out.println(results.toString());
        return results;
    }

    @RequestMapping(value = "/enrolledAtCourse/{courseID}", method = RequestMethod.GET)
    public List<Student> getEnrolledStudents(@PathVariable("courseID") int courseID){
        List<Student> results = courseService.getEnrolledStudents(courseID);
        return results;
    }

//    @RequestMapping(value = "/student/{id]", method = RequestMethod.GET)
//    public Student getStudentById(@PathVariable('id') int id){
//        //To be implemented
//    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }



}
