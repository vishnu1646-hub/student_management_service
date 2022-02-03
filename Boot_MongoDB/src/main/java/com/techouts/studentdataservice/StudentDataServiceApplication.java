package com.techouts.studentdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.techouts.studentdataservice.repository")
@ComponentScan("com.techouts.*")
public class StudentDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDataServiceApplication.class, args);
	}

}
