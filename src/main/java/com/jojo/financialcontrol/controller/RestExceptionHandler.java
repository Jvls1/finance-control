package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.dto.ApiErrorDTO;
import com.jojo.financialcontrol.exception.ConflictException;
import com.jojo.financialcontrol.exception.FinanceControlException;
import com.jojo.financialcontrol.utils.ApiErrorUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        return ApiErrorUtil.buildApiErrorResponse(new ApiErrorDTO());
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        return ApiErrorUtil.buildApiErrorResponse(new ApiErrorDTO());
    }

    @ExceptionHandler(value = {JwtException.class})
    protected ResponseEntity<Object> handleSignatureException(JwtException ex, WebRequest request) {
        ApiErrorDTO apiErrorDTO;
        if (ex instanceof SignatureException) {
            apiErrorDTO = new ApiErrorDTO("Invalid JWT signature", List.of(ex.getMessage()), HttpStatus.UNAUTHORIZED);
        } else if (ex instanceof MalformedJwtException) {
            apiErrorDTO = new ApiErrorDTO("Malformed JWT token", List.of(ex.getMessage()), HttpStatus.UNAUTHORIZED);
        } else if (ex instanceof ExpiredJwtException) {
            apiErrorDTO = new ApiErrorDTO("JWT token expired", List.of(ex.getMessage()), HttpStatus.UNAUTHORIZED);
        } else {
            apiErrorDTO = new ApiErrorDTO("JWT error", List.of(ex.getMessage()), HttpStatus.UNAUTHORIZED);
        }
        return ApiErrorUtil.buildApiErrorResponse(apiErrorDTO);
    }

    @ExceptionHandler(value = {FinanceControlException.class})
    protected ResponseEntity<Object> handleFinanceControlException(FinanceControlException ex, WebRequest request) {
        if(ex instanceof ConflictException) {
            var apiErrorDTO = new ApiErrorDTO("Resource Conflict", List.of(ex.getMessage()), HttpStatus.CONFLICT);
            return ApiErrorUtil.buildApiErrorResponse(apiErrorDTO);
        }
        return ApiErrorUtil.buildApiErrorResponse(new ApiErrorDTO());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(fieldError -> String.format("Field '%s': %s", fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList());

        var apiErrorDTO = new ApiErrorDTO("Validation failed for one or more fields.", errors, HttpStatus.BAD_REQUEST);
        return ApiErrorUtil.buildApiErrorResponse(apiErrorDTO);
    }

}
