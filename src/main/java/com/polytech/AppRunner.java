package com.polytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
        //String test = new BCryptPasswordEncoder().encode("a") ;
        SpringApplication.run(AppRunner.class, args);
    }
}
