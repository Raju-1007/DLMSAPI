package com.dlms.apigateway;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class RequestLoggingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("➡️ Gateway Received: " + exchange.getRequest().getURI());
        return chain.filter(exchange)
            .then(Mono.fromRunnable(() ->
                System.out.println("⬅️ Gateway Responded")
        ));
    }

    @Override
    public int getOrder() { return -1; }
}
