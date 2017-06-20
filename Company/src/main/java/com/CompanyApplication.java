package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.company.config.SSLCertificateValidation;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup() {
		return args -> {
			SSLCertificateValidation.disable();
		};
	}

}
