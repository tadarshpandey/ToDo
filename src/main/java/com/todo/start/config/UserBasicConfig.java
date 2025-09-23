package com.todo.start.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserBasicConfig {

    @Bean
    public SecurityFilterChain basicSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        // .securityMatcher("/userbasic/**") // Apply security only to /userbasic/**
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/todos/**").permitAll() // Allow all requests to /todos/**
            .requestMatchers("/userbasic/public").permitAll() // Public endpoint accessible to all
            .requestMatchers("/userbasic/account").hasRole("USER") // Account endpoint requires authentication
            .requestMatchers("/userbasic/admin").hasRole("ADMIN") // Admin endpoint requires ADMIN role
            .anyRequest().authenticated() // All other requests require authentication
        ).httpBasic (Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService basicUserDetailservice(){
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN", "USER")
            .build();
        UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("user")
        .roles("USER")
        .build();
        return new InMemoryUserDetailsManager(admin, user);

    }
}
