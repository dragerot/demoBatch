package com.example.config;

import com.example.services.ParseXMLService;
import com.example.services.ParseXMLServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CommonConfiguration {

    @Bean
    @Scope(value = "prototype")
    public ParseXMLService parseXMLService(){
       return new ParseXMLServiceImpl();
    }
}
