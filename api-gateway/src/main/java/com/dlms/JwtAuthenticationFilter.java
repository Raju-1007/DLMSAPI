package com.dlms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.dlms.service.SessionService;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtAuthenticationFilter implements WebFilter {

    
    private JwtUtil jwtUtil;
    private final SessionService sessionService;
    
    
    public JwtAuthenticationFilter(JwtUtil jwtUtil,SessionService sessionService) {
        this.jwtUtil = jwtUtil;
        this.sessionService = sessionService;
    }

    

 
    private static final List<String> PUBLIC_URLS = List.of(
            "/login/getRoles",
            "/login/generate",
            "/login/getloginData",
            "/login/forgot-password",
            "/login/addloginData",
            "/content/stream",
            "/login/forgotId"
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    	
    	 if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
    	        return chain.filter(exchange);
    	    }


        String path = exchange.getRequest().getURI().getPath();
        
        System.out.println(":::::::::::::::::::::::::::::::::::::::: PATH  :::::::::::::::::::::::::::::::::::::::: = " + exchange.getRequest().getURI().getPath());

        
        if (PUBLIC_URLS.stream().anyMatch(path::startsWith)) {
            return chain.filter(exchange);
        }

        String authHeader =
                exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        
        System.out.println(authHeader+"::::::::::::authHeader::::::::::::::::::::::::");
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return Mono.error(
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing token"));
        }

        String token = authHeader.substring(7);
        
        System.out.println(token+"::::::::::::::::::::::::::TOKEN:::::::::::::::::::::::::::::::::::::");

        try {
           
            Claims claims = jwtUtil.validateAndGetClaims(token);
            
            System.out.println(claims+"::::::::::::::::::::::::::claims+++++:::::::::::::::::::::::::::::::::::::");

            String userId = claims.getSubject();
            String role = claims.get("role", String.class);
            
            String sessionId = claims.get("sessionId", String.class);

            System.out.println(userId+"::::::::::::::::::::::::::userId:::::::::::::::::::::::::::::::::::::");
            System.out.println(role+"::::::::::::::::::::::::::role:::::::::::::::::::::::::::::::::::::");
           
            if (sessionService != null &&
                !sessionService.isSessionActive(userId, token)) {

                return Mono.error(
                    new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Session expired or logged out"));
            }

           
            Authentication auth =
                    new UsernamePasswordAuthenticationToken(
                            userId,
                            null,
                            List.of(new SimpleGrantedAuthority("ROLE_" + role))
                    );
         // 6️⃣ Forward user context headers (optional, useful)
            ServerWebExchange mutated = exchange.mutate()
              .request(r -> r.headers(h -> {
                h.add("X-User-Id", userId);
                h.add("X-Role", role);
                h.add("X-Session-Id", sessionId);
              }))
              .build();

            return chain.filter(mutated)
                    .contextWrite(
                        ReactiveSecurityContextHolder.withAuthentication(auth)
                    );

        } 
        catch (Exception e) {
            System.out.println("❌ JWT VALIDATION FAILED:::::::::::::::::::::::::::::::::::::::::::::");
            
            e.printStackTrace();   // ⭐ THIS IS THE KEY
            return Mono.error(
                new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Invalid token"));
        }    }
}
