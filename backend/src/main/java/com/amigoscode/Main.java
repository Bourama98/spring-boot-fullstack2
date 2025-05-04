package com.amigoscode;

import com.amigoscode.customer.Customer;
import com.amigoscode.customer.CustomerRepository;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication

public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository){

        return  args -> {
            Faker faker = new Faker();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = faker.name().lastName();
            String email = firstName.toLowerCase()+"."+lastName.toLowerCase() + "@gmail.com";
            Integer age = faker.number().numberBetween(1, 100);
            Customer customer = new Customer(
                    firstName + " " + lastName,
                    email,
                    age
            );

            customerRepository.save(customer);
        };
}

}
