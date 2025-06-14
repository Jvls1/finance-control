package com.jvls.financialcontrol.controllers;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.jvls.financialcontrol.constants.Routes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Getter
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    private HttpHeaders jwtAuthenticationHeader;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void loginTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + Routes.AUTH;
        URI uri = new URI(baseUrl);

        HttpHeaders basicLoginHeader = new HttpHeaders();

        basicLoginHeader.add("Authorization", "Basic am/Do286MTIzNDU2Nzg=");

        HttpEntity<Object> request = new HttpEntity<>(basicLoginHeader);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        List<String> authorization = result.getHeaders().get("Authorization");

        Assertions.assertNotNull(authorization);

        String token = authorization.get(0);
        jwtAuthenticationHeader = new HttpHeaders();
        jwtAuthenticationHeader.add("Authorization", "Bearer " + token);

        Assertions.assertEquals(200, result.getStatusCode().value());
    }
}