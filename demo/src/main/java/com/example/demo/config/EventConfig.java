package com.example.demo.config;
import com.example.demo.Entity.Events;
import com.example.demo.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EventConfig {
    @Bean
    CommandLineRunner commandLineRunner(EventRepository repository){
        return args -> {
            Events michelle = new Events(
                    "watermelon_festival",
                    "WaterValley",
                    LocalDate.of(2023, Month.JULY,12),
                    "celebrating the harvest of watermelon"
            );
            Events logan = new Events(
                    "elvis_birthday",
                    "Tupelo",
                    LocalDate.of(2023, Month.FEBRUARY,12),
                    "Celebrating the king of rock and roll"


            );
            Events ryan = new Events(
                    "railroad_festival",
                    "Amory",
                    LocalDate.of(2023, Month.MAY,12),
                    "Celebrating the train empire"

            );
            repository.saveAll(
                    List.of(michelle,ryan,logan)
            );

        };
    }
}
