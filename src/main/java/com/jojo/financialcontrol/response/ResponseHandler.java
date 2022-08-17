package com.jojo.financialcontrol.response;

import com.jojo.financialcontrol.entity.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResponseHandler {

    public static <T> ResponseEntity<Object> getResponse(Optional<T> entity) {
        if (entity.isPresent()) {
            return generateResponse(
                    "Find!",
                    HttpStatus.OK,
                    entity
            );
        }
        return generateResponse(
                "Error!",
                HttpStatus.BAD_REQUEST,
                null
        );
    }

    public static <T extends BaseEntity> ResponseEntity<Object> saveResponse(T entity) {
        if (entity != null) {
            return generateResponse(
                    "Find!",
                    HttpStatus.OK,
                    entity
            );
        }
        return generateResponse(
                "Error!",
                HttpStatus.BAD_REQUEST,
                null
        );
    }

    private static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<>(map, status);
    }

}
