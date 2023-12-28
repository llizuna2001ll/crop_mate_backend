package com.brogrammers.landservice.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/v1/lands/**").permitAll() // Allow access to land-service endpoints
                .anyRequest().denyAll() // Deny access to any other endpoint by default
                .and()
                .cors() // Enable CORS
                .and()
                .csrf().disable(); // Disable CSRF for simplicity
    }
}

