package com.secretescapes.paymentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PaymentappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentappApplication.class, args);
        System.out.println("Welcome to Secret Escapes Payment application!");
    }

}
