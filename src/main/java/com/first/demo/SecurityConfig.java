package com.first.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ako koristiš API
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // dozvoli sve bez autentifikacije
                )
                .httpBasic(httpBasic -> httpBasic.disable()) // isključi Basic auth
                .formLogin(form -> form.disable()); // isključi login formu

        return http.build();
    }
}
