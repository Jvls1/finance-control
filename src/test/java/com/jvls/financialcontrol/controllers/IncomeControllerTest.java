package com.jvls.financialcontrol.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.jvls.financialcontrol.constants.Routes;
import com.jvls.financialcontrol.dtos.IncomeCreationDTO;
import com.jvls.financialcontrol.entities.Income;
import com.jvls.financialcontrol.repositories.IIncomeRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class IncomeControllerTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private IIncomeRepository iIncomeRepository;

    @Test
    void findAll() {
        final String requestUrl = "http://localhost:" + randomServerPort + Routes.INCOME;

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);
        Assertions.assertEquals(201, result.getStatusCode().value());
    }

    @Test
    void getExpenseById() {
        List<Income> incomes = iIncomeRepository.findAll();
        Income income = incomes.get(0);
        Assertions.assertNotNull(income);

        final String requestUrl = "http://localhost:" + randomServerPort + Routes.INCOME + "/" + income.getId();

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);
        Assertions.assertEquals(200, result.getStatusCode().value());
    }

    @Test
    void save() {
        final String requestUrl = "http://localhost:" + randomServerPort + Routes.INCOME;

        IncomeCreationDTO incomeCreationTO = new IncomeCreationDTO();
        incomeCreationTO.setAmount(new BigDecimal("10"));
        incomeCreationTO.setDescription("Test");
        /**
         * TODO:
         *
         * Change this UUID to a valid one later.
         */
        incomeCreationTO.setIdWallet(new UUID(1, 2));

        HttpEntity<Object> request = new HttpEntity<>(incomeCreationTO, getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.POST, request, String.class);
        Assertions.assertEquals(200, result.getStatusCode().value());
    }

    @Test
    void deleteById() {
        List<Income> incomes = iIncomeRepository.findAll();
        Income income = incomes.get(0);
        Assertions.assertNotNull(income);

        final String requestUrl = "http://localhost:" + randomServerPort + Routes.EXPENSE + "/" + income.getId();

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.DELETE, request, String.class);
        Assertions.assertEquals(200, result.getStatusCode().value());
    }
}