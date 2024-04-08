package com.myapplication.dantestapp.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {


            Student miriam = new Student(
                    "Miriam",
                    "miriam.jamal@gmil.com",
                    LocalDate.of(2000, 5, 27),
                    24

            );
            Student alex = new Student(
                    "Alex",
                    "alex.kubasi@gmil.com",
                    LocalDate.of(2002, 5, 27),
                    22

            );
            studentRepository.save(miriam);
            studentRepository.save(alex);

        };
    }
}
