package com.jojo.financialcontrol.config;

import com.jojo.financialcontrol.constants.SecurityConstants;
import com.jojo.financialcontrol.filter.JWTTokenGeneratorFilter;
import com.jojo.financialcontrol.constants.Routes;
import com.jojo.financialcontrol.filter.JWTTokenValidatorFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final SecurityConstants securityConstants;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable()
                .addFilterAfter(new JWTTokenGeneratorFilter(securityConstants), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(securityConstants), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(Routes.LOGIN).permitAll()
                .requestMatchers(HttpMethod.POST, Routes.USER).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
