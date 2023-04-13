package com.jojo.financialcontrol.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class SecurityConstants {

    private String jwtKey;

    public static final String JWT_HEADER = "Authorization";
    public static final String JWT_PREFIX = "Bearer ";

    @Autowired
    public SecurityConstants(@Value("${spring.authentication.jwt-secret}") String jwtKey) {
        this.jwtKey = jwtKey;
    }

    public String getJwtKey() {
        return jwtKey;
    }
}
