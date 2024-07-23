package com.example.coursms.repositoire;


import com.example.coursms.entity.Cours;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Cours, String> {
}
