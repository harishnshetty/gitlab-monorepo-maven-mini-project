package com.example.ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class App1 {

    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hello from MicroService1!";
    }
}
