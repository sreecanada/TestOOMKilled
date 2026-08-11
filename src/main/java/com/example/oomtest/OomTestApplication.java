package com.example.oomtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class OomTestApplication {

    private final List<byte[]> memory = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(OomTestApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "OOM test application is running";
    }

    @GetMapping("/consume-memory")
    public String consumeMemory() {

        for (int i = 0; i < 100; i++) {
            memory.add(new byte[10 * 1024 * 1024]);
        }

        return "Memory allocation completed";
    }
}