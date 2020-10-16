package com.bridgelabz.GreetingApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingControllerConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
