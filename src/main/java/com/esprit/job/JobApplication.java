package com.esprit.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}


	@Autowired
	private JobRepository jobRepository;

	@Bean
	ApplicationRunner init(){
		return (args)-> {
			//Save
			jobRepository.save(new Job("Aziz","Is",false));
			jobRepository.save(new Job("Ahmed","Is",false));
			jobRepository.save(new Job("Hamza","Is",false));
			//fetch
			jobRepository.findAll().forEach(System.out::println);
		};
	}

}
