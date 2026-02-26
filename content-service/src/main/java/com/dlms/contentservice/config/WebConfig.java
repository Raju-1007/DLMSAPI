package com.dlms.contentservice.config;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

		String uploadPath = "file:" + 
		        Paths.get("uploads").toAbsolutePath().toString() + "/";

		    registry.addResourceHandler("/uploads/**")
		            .addResourceLocations(uploadPath);

		    System.out.println("Serving files from: " + uploadPath);
    }
}
