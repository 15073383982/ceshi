package com.example.swaggerdemo9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Swaggerdemo9Application {

    public static void main(String[] args) {

        System.out.println(11);
        SpringApplication.run(Swaggerdemo9Application.class, args);
    }

}
