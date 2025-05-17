package com.jojo.financialcontrol.constants;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@Getter
public class SecurityConstants implements EnvironmentAware {

    @Autowired
    private Environment environment;
    private String jwtKey;
    public static final String JWT_HEADER = "Authorization";
    public static final String JWT_PREFIX = "Bearer ";

    @PostConstruct
    public void load() {
        jwtKey = environment.getProperty("spring.authentication.jwt-secret");
    }

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }
}
