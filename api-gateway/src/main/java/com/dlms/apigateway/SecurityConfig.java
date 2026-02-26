package com.dlms.apigateway;



import java.util.Arrays;
import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.dlms.JwtAuthenticationFilter;
import com.dlms.JwtUtil;
import com.dlms.service.SessionService;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter(
	        JwtUtil jwtUtil, SessionService sessionService) {

	    return new JwtAuthenticationFilter(jwtUtil, sessionService);
	}


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) {
    	System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::SECURITY CONFIG LOADED+++++:::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        return http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .cors(Customizer.withDefaults())
            .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
            .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)

            .authorizeExchange(exchanges -> exchanges
            		.pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 🔓 PUBLIC LOGIN APIs
                .pathMatchers(
                    "/login/getRoles",
                    "/login/generate",
                    "/login/getloginData",
                    "/login/forgot-password",
                    "/login/addloginData",
                    "/content/stream",
                    "/login/forgotId"
                ).permitAll()

                // 🔐 ROLE BASED ROUTES (COARSE-GRAINED)
                .pathMatchers("/login/update-profile/**").hasRole("STUDENT")
                .pathMatchers("/login/getVillages/**").hasRole("STUDENT")
                .pathMatchers("/login/getMandals/**").hasRole("STUDENT")
                .pathMatchers("/login/getDistricts/**").hasRole("STUDENT")
                .pathMatchers("/login/getSchools/**").hasRole("STUDENT")
                .pathMatchers("/login/getClasses/**").hasRole("STUDENT")
                .pathMatchers("/login/refresh/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN", "SUPER_ADMIN")
                .pathMatchers("/login/teacher/**").hasRole("TEACHER")
                 

                .pathMatchers("/super-admin/**").hasRole("SUPER_ADMIN")
                .pathMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")
                .pathMatchers("/teacher/**").hasAnyRole("TEACHER", "ADMIN", "SUPER_ADMIN")
                .pathMatchers("/student/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN", "SUPER_ADMIN")

                // 🔐 EVERYTHING ELSE
                .anyExchange().authenticated()
            )
            
            .addFilterAt(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
            // 🔐 CUSTOM UNAUTHORIZED HANDLER (WEBFLUX WAY)
            
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((exchange, ex1) -> {
                	 System.out.println("🚨 401 FROM API GATEWAY 🚨Spring-security");
                    exchange.getResponse().setRawStatusCode(HttpStatus.SC_UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                })
                .accessDeniedHandler((exchange, ex1) -> {
                    System.out.println("🚫 403 FROM API GATEWAY 🚫--spring security");
                    exchange.getResponse().setRawStatusCode(403);
                    return exchange.getResponse().setComplete();
                })
                
            )
            .addFilterAt(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)

            .build();
    }
    
    @Bean
    public CorsWebFilter corsWebFilter() {

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173","http://52.140.42.14:5173"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
    


