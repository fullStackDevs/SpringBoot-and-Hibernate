package com.service;

import com.entity.Course;
import com.entity.Student;
import com.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getCourses(){
        return courseRepository.getCourses();
    }

    public List<Student> getEnrolledStudents(int courseID){
        Course course = courseRepository.getCourse(courseID);
        return course.getStudents();
    }
}
