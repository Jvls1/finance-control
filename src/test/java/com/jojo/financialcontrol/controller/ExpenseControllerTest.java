package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.constants.Routes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class ExpenseControllerTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private IUserRepository iUserRepository;

    @Test
    void findAll() {
        final String requestUrl = "http://localhost:" + randomServerPort + Routes.WALLET;

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);
        Assertions.assertEquals(201, result.getStatusCode().value());
    }

    @Test
    void getExpenseById() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }
}