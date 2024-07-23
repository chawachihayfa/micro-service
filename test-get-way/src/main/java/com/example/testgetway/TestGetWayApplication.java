package com.example.testgetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestGetWayApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestGetWayApplication.class, args);
    }

    @Bean
    public DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, properties);


//		@Bean
//		public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//			return builder.routes()
//					.route("product-service", r -> r.path("/product/**")
//							.uri("lb://ms-product"))
//					.route("stock-service", r -> r.path("/stock/**")
//							.uri("lb://ms-stock"))
//					.build();
//		}
    }
}