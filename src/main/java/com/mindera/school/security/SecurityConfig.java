package com.mindera.school.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/login", "/api/v1/register", "/swagger-ui/**", "/api-docs", "/swagger-ui/index.html", "/v2/api-docs").permitAll()
                        .requestMatchers("/api/v1/teacher/**").hasAuthority("TEACHER")
                        .requestMatchers("/api/v1/student/**").hasAuthority("STUDENT")
                        .requestMatchers("/api/v1/dev/**").hasAuthority("DEV")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
