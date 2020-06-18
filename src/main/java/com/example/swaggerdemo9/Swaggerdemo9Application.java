package com.example.swaggerdemo9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Swaggerdemo9Application {

    public static void main(String[] args) {
        /*String a=new String("ab");
        String b=new String("ab");
        String aa="ab";
        String bb="ab";
        System.out.println(aa==bb);
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(42==42.0);*/
        SpringApplication.run(Swaggerdemo9Application.class, args);
    }

}
