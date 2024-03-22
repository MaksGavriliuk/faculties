package org.example.faculties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FacultiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacultiesApplication.class, args);
    }

}
