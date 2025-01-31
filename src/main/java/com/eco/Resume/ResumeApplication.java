package com.eco.Resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ResumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeApplication.class, args);
	}

}
