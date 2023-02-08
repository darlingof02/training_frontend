package com.kaseya.kaseyatraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.kaseya")
@ComponentScan("com.kaseya")
@EnableJpaRepositories("com.kaseya")
public class KaseyaTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaseyaTrainingApplication.class, args);
    }

}
