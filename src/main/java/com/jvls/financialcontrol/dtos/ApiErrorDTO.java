package com.jvls.financialcontrol.dtos;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDTO {
    private String message = "An unexpected error occurred";
    private List<String> errors;
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    // private String timestamp;
}
