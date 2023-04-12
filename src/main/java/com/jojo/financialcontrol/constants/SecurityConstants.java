package com.jojo.financialcontrol.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityConstants {

    @Value("${spring.authentication.jwt-secret}")
    public static String JWT_KEY;
    public static final String JWT_HEADER = "Authorization";
    public static final String JWT_PREFIX = "Bearer ";

}
