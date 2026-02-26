package com.dlms.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Configuration
public class RateLimitConfig {

    private static final Logger log =
            LoggerFactory.getLogger(RateLimitConfig.class);

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            String ip = extractClientIp(exchange);
            
            log.info("🌐 RATE-LIMIT IP: {}", ip);
            return Mono.just(ip);
        };
    }

    private String extractClientIp(ServerWebExchange exchange) {

        // 1️⃣ Reverse proxy / Load balancer (PROD)
        String xForwardedFor =
                exchange.getRequest().getHeaders().getFirst("X-Forwarded-For");

        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0].trim();
        }

        // 2️⃣ Direct client IP (DEV / LOCAL)
        if (exchange.getRequest().getRemoteAddress() != null) {
            return exchange.getRequest()
                    .getRemoteAddress()
                    .getAddress()
                    .getHostAddress();
        }

        return "UNKNOWN-IP";
    }
}
