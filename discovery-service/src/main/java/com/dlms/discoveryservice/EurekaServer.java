package com.dlms.discoveryservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
	public static void main(String[] a) {
		SpringApplication.run(EurekaServer.class, a);
	}
}