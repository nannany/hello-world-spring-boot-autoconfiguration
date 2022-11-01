package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.controller.HelloWorldController;

@AutoConfiguration
public class HelloWorldAutoConfiguration {

    @Bean
    @ConditionalOnWebApplication
    public HelloWorldController helloWorldController(){
        return new HelloWorldController();
    }

}
