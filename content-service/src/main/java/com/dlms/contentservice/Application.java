package com.dlms.contentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dlms.contentservice","com.dlms.contentservice.config"})
@EnableJpaRepositories(basePackages = {"com.dlms.contentservice.repo","com.dlms.contentservice.service"})
@EntityScan(basePackages = "com.dlms.contentservice.model")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
