package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTests extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private IUserRepository iUserRepository;

    @BeforeAll
    public void defaultTest() throws URISyntaxException {
        loginTest();
    }

    @Test
    public void testFindById() {
        List<User> users = iUserRepository.findAll();

        User user = null;

        if (users.size() > 0) {
            user = users.get(0);
        }

        assert user != null;

        UUID id = user.getId();

        final String requestUrl = "http://localhost:" + randomServerPort + "/api/user/" + id;

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);

        Assertions.assertEquals(201, result.getStatusCode().value(), "User founded");

    }

    @Test
    public void testSaveUser() {
        //TODO: implement test
    }
}