package com.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableWebMvc
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);       
    }
}
