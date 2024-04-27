package com.att.tdp.bisbis10;

import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = RestaurantRepository.class)
public class Bisbis10Application {

    public static void main(String[] args) {
        SpringApplication.run(Bisbis10Application.class, args);
    }

}
