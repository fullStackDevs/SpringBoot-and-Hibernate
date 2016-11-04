package com.controller;

import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    CourseService courseService;

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


}
