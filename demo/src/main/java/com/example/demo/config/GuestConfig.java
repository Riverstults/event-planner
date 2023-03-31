package com.example.demo.config;
import com.example.demo.Entity.Events;
import com.example.demo.Entity.Guest;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.GuestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class GuestConfig {
    @Bean
    CommandLineRunner commandLineRunners(GuestRepository repository){
        return args -> {
            Guest michelle = new Guest(
                    "michelle",
                    "michelle@gmail",
                    "no street ave"
            );
            Guest logan = new Guest(
                    "logan",
                    "logan@gmail",
                    "dylan st"
            );
            Guest ryan = new Guest(
                    "ryan",
                    "ryan@gmail",
                    "riverdale st"
            );
            repository.saveAll(
                    List.of(michelle,ryan,logan));
            };}}