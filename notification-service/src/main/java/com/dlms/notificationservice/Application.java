package com.dlms.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication(scanBasePackages = {"com.dlms.notificationservice"})
@EnableFeignClients
public class Application {
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		System.out.println("notfication service application hit");
	}
}
