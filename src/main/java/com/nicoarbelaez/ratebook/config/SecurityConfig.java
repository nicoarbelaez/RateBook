package com.nicoarbelaez.ratebook.config;

import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    
    public SecurityFilterAutoConfiguration securityFilterAutoConfiguration() {
        return new SecurityFilterAutoConfiguration();
    }
}
