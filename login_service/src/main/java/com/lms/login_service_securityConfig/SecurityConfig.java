package com.lms.login_service_securityConfig;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> {})
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/getRoles",
                    "/generate",
                    "/getloginData",
                    "/forgot-password",
                    "/addloginData",
                    "/forgotId"
                ).permitAll()
                
                
                
                
                
                .requestMatchers(
                        "/getMandals/**",
                        "/getDistricts/**",
                        "/getVillages/**",
                        "/getSchools/**",
                        "/getClasses/**"
                    ).hasRole("STUDENT")

                
               
                .requestMatchers("/super-admin/**").hasRole("SUPER_ADMIN")
                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")
                .requestMatchers("/teacher/**").hasAnyRole("TEACHER", "ADMIN", "SUPER_ADMIN")
                .requestMatchers("/student/**")
                    .hasAnyRole("STUDENT", "TEACHER", "ADMIN", "SUPER_ADMIN")
                
                  
                .anyRequest().authenticated()
                
                
                
                
            )
        
        .exceptionHandling(ex ->
        ex.accessDeniedHandler((req, res, e) -> {
            System.out.println("🚫 403 FROM LOGIN SERVICE");
            res.setStatus(403);
        })
        );

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        

        return http.build();
    }
}