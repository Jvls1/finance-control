package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.constants.Routes;
import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.to.ExpenseCreationTO;
import com.jojo.financialcontrol.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ExpenseControllerTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private IUserRepository iUserRepository;

    @Test
    void findAll() {
        final String requestUrl = "http://localhost:" + randomServerPort + Routes.EXPENSE;

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);
        Assertions.assertEquals(201, result.getStatusCode().value());
    }

    @Test
    void getExpenseById() {
        List<User> users = iUserRepository.findAll();
        User user = users.get(0);
        Assertions.assertNotNull(user);

        final String requestUrl = "http://localhost:" + randomServerPort + Routes.EXPENSE + "/" + user.getId();

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);
        Assertions.assertEquals(200, result.getStatusCode().value());
    }

    @Test
    void save() {
        final String requestUrl = "http://localhost:" + randomServerPort + Routes.EXPENSE;

        ExpenseCreationTO expenseCreationTO = new ExpenseCreationTO();
        expenseCreationTO.setAmount(new BigDecimal("10"));
        expenseCreationTO.setDescription("Test");
        /**
         * TODO:
         *
         * Change this UUID to a valid one later.
         */
        expenseCreationTO.setIdWallet(new UUID(1, 2));
        expenseCreationTO.setEnumBuyMethod(EnumBuyMethod.OTHER);

        HttpEntity<Object> request = new HttpEntity<>(expenseCreationTO, getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.POST, request, String.class);
        Assertions.assertEquals(200, result.getStatusCode().value());
    }

    @Test
    void deleteById() {
        List<User> users = iUserRepository.findAll();
        User user = users.get(0);
        Assertions.assertNotNull(user);

        final String requestUrl = "http://localhost:" + randomServerPort + Routes.EXPENSE + "/" + user.getId();

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.DELETE, request, String.class);
        Assertions.assertEquals(200, result.getStatusCode().value());
    }
}