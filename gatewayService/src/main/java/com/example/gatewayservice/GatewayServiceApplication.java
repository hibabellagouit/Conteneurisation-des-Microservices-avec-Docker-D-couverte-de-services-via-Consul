package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * Service Gateway pour l'application de gestion de flotte automobile
 * 
 * Ce service agit comme un point d'entrée unique pour toutes les requêtes API
 * et les route vers les services appropriés.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

    /**
     * Point d'entrée principal de l'application
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    /**
     * Configuration du routage statique (alternative à la découverte de service)
     * Décommentez cette méthode si vous souhaitez utiliser le routage statique
     * au lieu de la découverte de service.
     * 
     * @param builder Constructeur de routes
     * @return Configuration du routeur
     */
    // @Bean
    // public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    //     return builder.routes()
    //         // Route pour le service client
    //         .route("client_route", r -> r.path("/clients/**")
    //             .uri("lb://client-service"))
    //             
    //         // Route pour le service voiture
    //         .route("voiture_route", r -> r.path("/voitures/**")
    //             .uri("lb://voiture-service"))
    //         .build();
    // }
}
