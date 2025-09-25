package com.example.ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class App3 {

    public static void main(String[] args) {
        SpringApplication.run(App3.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hello from MicroService3! new lines added";
    }
}
