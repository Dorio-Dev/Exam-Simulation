package com.daradat.exam;

import com.daradat.exam.cm.dto.Exam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }

    /*@Bean(name = "exam")
    public Exam exam(){
        Exam exam = new Exam();
        return exam;
    }*/

}
