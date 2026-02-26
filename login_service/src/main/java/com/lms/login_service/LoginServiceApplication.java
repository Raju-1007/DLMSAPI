package com.lms.login_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.lms","com.lms.login_service_Controller"})
@EnableJpaRepositories(basePackages = "com.lms.login_service_interface")
@EntityScan(basePackages = "com.lms.login_service_Model")

public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

}
