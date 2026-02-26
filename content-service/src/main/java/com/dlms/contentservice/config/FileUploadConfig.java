package com.dlms.contentservice.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import jakarta.servlet.MultipartConfigElement;

@Configuration
public class FileUploadConfig {

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofGigabytes(6));
        factory.setMaxRequestSize(DataSize.ofGigabytes(6));
        return factory.createMultipartConfig();
    }
    
    @Bean
    public String uploadRoot() {
        return System.getProperty("user.dir") + "/uploads/";
    }
}