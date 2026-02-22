package com.example.start1.Config;

import com.example.start1.DTO.ProductRequestDTO;
import com.example.start1.Entities.ProductEntity;
import com.example.start1.Exceptions.ProductNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
