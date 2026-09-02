package ru.vasko1300.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Router {
    private final Filter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        System.out.println("СТАРТ РОУТЕРА");
        return builder.routes()
                .route("client", r -> r.path("/api/client/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://client-service"))
                .build();
    }
}
