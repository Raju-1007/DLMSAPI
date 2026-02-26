package com.dlms.contentservice;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String fullUrl = request.getRequestURL().toString();
        String query = request.getQueryString();

        System.out.println("🌍 [Content-Service-====================================] Request URL: " + fullUrl +
                (query != null ? "?" + query : "") +
                " | Method: " + request.getMethod());

        filterChain.doFilter(request, response);
    }
}
