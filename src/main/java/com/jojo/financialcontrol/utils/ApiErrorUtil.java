package com.jojo.financialcontrol.utils;

import org.springframework.http.ResponseEntity;

import com.jojo.financialcontrol.dto.ApiErrorDTO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiErrorUtil {
    
    public static ResponseEntity<Object> buildApiErrorResponse(
        ApiErrorDTO apiErrorDTO
    ) {
        return ResponseEntity
            .status(apiErrorDTO.getStatus())
            .body(apiErrorDTO);
    }
}
