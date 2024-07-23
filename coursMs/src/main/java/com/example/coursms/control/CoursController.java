package com.example.coursms.control;


import com.example.coursms.entity.Cours;
import com.example.coursms.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CoursController {
    @Autowired
    private CoursService courseService;

    @GetMapping
    public List<Cours> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Cours getCourseById(@PathVariable String id) {
        Cours course = courseService.getCourseById(id);
        return course;
    }


    @PostMapping
    public Cours createCourse(@RequestBody Cours cours) {
        return courseService.createCourse(cours);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cours> updateCourse(@PathVariable String id, @RequestBody Cours courseDetails) {
        Cours updatedCourse = courseService.updateCourse(id, courseDetails);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}