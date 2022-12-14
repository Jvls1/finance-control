package com.jojo.financialcontrol.response;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import org.springframework.http.ResponseEntity;

public interface IResponseHandler {

    static <T> ResponseEntity<Object> getResponse(T entity) {
        return null;
    }

    static <T extends BaseEntity> ResponseEntity<Object> saveResponse(T entity) {
        return null;
    }
}
