package com.example.DTODemo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoDemoApplication {
	
	//step1 -> Add ModelMapper Library Dependency
	
	//step2 -> Define the ModelMapper Bean in our spring configuration.
	
	//step3 -> Inject and use ModelMapper
	
	@Bean
	public ModelMapper modelMapper() {
		System.out.println("we are in model mapper bean");
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DtoDemoApplication.class, args);
	}

}
