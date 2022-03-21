package com.modak.fl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {
    "com.modak.fl"
})

public class ModakApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModakApplication.class, args);
    }

}
