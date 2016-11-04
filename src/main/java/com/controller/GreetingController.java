package com.controller;

import com.entity.Student;
import com.service.CourseService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class GreetingController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/greeting")
    public String getGreeting(){
        return "HelloWorld";
    }

    @RequestMapping(value = "/courses")
    public String testCoursesList(){
       int nrCourses =  courseService.getCourses().size();
        System.out.println("Nr of courses: " + nrCourses);
        return("Nr of courses: " + nrCourses);
    }


    @RequestMapping(value = "/students")
    public Collection<Student> getAllStudents(){
        Collection<Student> results = studentService.getAll();
        System.out.println(results.toString());
        return results;
    }



}
