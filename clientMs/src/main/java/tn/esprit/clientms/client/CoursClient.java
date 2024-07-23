package tn.esprit.clientms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.clientms.dto.CoursDto;

@FeignClient(name = "courses", url = "http://localhost:9091") // URL du microservice Stock

public interface CoursClient {

    @GetMapping("/courses/{id}")
    CoursDto getCourseById(@PathVariable String id);
}
