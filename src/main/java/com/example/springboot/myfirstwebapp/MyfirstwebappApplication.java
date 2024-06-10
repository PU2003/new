package com.example.springboot.myfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MyfirstwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstwebappApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsCongifurer(){
		return new WebMvcConfigurer() {

			public void addCorsMappings(CorsRegistry registry) {                         // defining the WebMvcConfigurer,where we are returning a new instance of
				registry.addMapping("/**")                                    // WebMvcConfigurer with one of the methods overwritten
						.allowedMethods("*")                                            //we want to override addCorsMappings method
						.allowedOrigins("http://localhost:3000");
			}                                                                           // we want to add mapping.So,add mapping,enable cross-origin request handling for
		};                                                                              // for the specified path pattern
	}                                                                                   // we want to make it enable for everything by saying that /**
}                                                                                       // Next,what kinds of method are allowed,hence  '*'
                                                                                       // allowedOrigin tells from where our requests are coming