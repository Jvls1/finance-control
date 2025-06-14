package com.jvls.financialcontrol.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDTO {
    
    private String token;

    private long expiresIn;
}
