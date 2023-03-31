package com.example.demo.config;
import com.example.demo.Entity.Vendors;
import com.example.demo.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VendorConfig {
    @Bean
    CommandLineRunner commandLineRunnerv(VendorRepository repository){
        return args -> {
            Vendors michelle = new Vendors(
                    "pineapple",
                    "michelle@gmail",
                    351454568,
                    "pineapples"
            );
            Vendors logan = new Vendors(
                    "chicken",
                    "logan@gmail",
                    653294478,
                    "chickens"
            );
            Vendors ryan = new Vendors(
                    "tacos",
                    "ryan@gmail",
                    57859542,
                    "tacos"
            );
            repository.saveAll(
                    List.of(michelle,ryan,logan));
        };}}