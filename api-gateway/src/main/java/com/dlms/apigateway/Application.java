package com.dlms.apigateway;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.dlms.apigateway","com.dlms"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	 @Bean
//	    public CommandLineRunner logRoutes(RouteDefinitionLocator  locator) {
//	        return args -> locator.getRouteDefinitions().subscribe(route ->
//	            System.out.println("🛠️ Loaded route: " + route.getId() + " -> " + route.getUri())
//	        );
//	    }
}
