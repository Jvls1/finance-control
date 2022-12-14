package com.jojo.financialcontrol.response;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static <T> ResponseEntity<Object> getResponse(T entity) {
        if (entity != null) {
            return generateResponse(
                    "Find!",
                    HttpStatus.OK
            );
        }
        return generateResponse(
                "Error!",
                HttpStatus.BAD_REQUEST
        );
    }

    public static <T extends BaseEntity> ResponseEntity<Object> saveResponse(String message, HttpStatus status) {
        if (message != null && status != null) {
            return generateResponse(
                    message,
                    status
            );
        }
        return generateResponse(
                "Error",
                HttpStatus.BAD_REQUEST
        );
    }

    private static ResponseEntity<Object> generateResponse(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());

        return new ResponseEntity<>(map, status);
    }

}
