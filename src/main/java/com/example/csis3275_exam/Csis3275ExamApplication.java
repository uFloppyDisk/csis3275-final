package com.example.csis3275_exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class})
public class Csis3275ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(Csis3275ExamApplication.class, args);
    }

}
