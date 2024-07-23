package com.example.coursms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoursMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursMsApplication.class, args);
    }

}
