package com.lsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties
@SpringBootApplication
public class BackendninjaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendninjaApplication.class, args);
    }

}

