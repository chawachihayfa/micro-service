package com.example.inscriptionms.client;

import com.example.inscriptionms.dto.CoursDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "courses", url = "http://localhost:9091") // URL du microservice Stock

public interface CoursClient {

    @GetMapping("/courses/{id}")
    CoursDto getCourseById(@PathVariable String id);
}
