package com.evander.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DesafioEvanderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesafioEvanderApplication.class, args);
    }
}
