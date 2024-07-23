package com.example.coursms.service;


import com.example.coursms.entity.Cours;
import com.example.coursms.repositoire.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Cours> getAllCourses() {
        return courseRepository.findAll();
    }

    public Cours getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Cours createCourse(Cours course) {
        return courseRepository.save(course);
    }

    public Cours updateCourse(String id, Cours courseDetails) {
        Cours course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setTitle(courseDetails.getTitle());
            course.setDescription(courseDetails.getDescription());
            course.setInstructor(courseDetails.getInstructor());
            course.setContent(courseDetails.getContent());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}

