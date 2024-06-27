package com.example.demo;

import com.example.demo.Entity.TaskCategories;
import com.example.demo.Repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class StudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}
	@Bean
	CommandLineRunner run(CategoryRepository categoryRepository) {
		return args -> {
			categoryRepository.save(new TaskCategories(null, "hair"));
			categoryRepository.save(new TaskCategories(null, "electronic"));
			categoryRepository.save(new TaskCategories(null, "house"));
			categoryRepository.save(new TaskCategories(null, "animal"));
			categoryRepository.save(new TaskCategories(null, "clothes"));
		};
	}

	}



