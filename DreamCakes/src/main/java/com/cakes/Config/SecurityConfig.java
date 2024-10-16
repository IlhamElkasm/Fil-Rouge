package com.cakes.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/api/v1/auth/registerAdmin","/api/v1/auth/register", "/api/v1/auth/authenticate").permitAll()
                                .requestMatchers("/api/v1/User/**").hasAuthority("USER")
//                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers("/api/v1/Admin/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/show","/api/v1/get/{id}",
                                        "/api/v1/Saveur/all", "/api/v1/Saveur/get/{id}","/api/v1/garniture/all"
                                        ,"/api/v1/garniture/get/{id}").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers( "/update/{id}" ,"/{id}").hasAuthority("ADMIN")
                                .requestMatchers( "/edit/{id}", "/{id}").hasAuthority("ADMIN")
                                .requestMatchers( "/edit/{id}", "/{id}").hasAuthority("ADMIN")
                                .requestMatchers( "/api/v1/commande/add", "/show").hasAuthority("USER")
                                .requestMatchers( "/api/v1/commande/all").hasAuthority("ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}
