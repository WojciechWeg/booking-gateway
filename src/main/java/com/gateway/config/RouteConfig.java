package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return  builder.routes()
                .route(r -> r.path("/bookRoom*","/bookRoom/*","/bookRoom?*","/bookRoom/givenRoom?*","/bookRoom/givenUser?*")
                    .uri("lb://BOOKING-SERVICE"))
                .route(r -> r.path("/room/*")
                    .uri("lb://ROOM-SERVICE"))
                .route(r -> r.path("/user/*")
                    .uri("lb://USER-SERVICE"))
                .build();
    }

}
