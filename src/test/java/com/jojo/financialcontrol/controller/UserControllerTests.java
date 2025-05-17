package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.to.UserCreationTO;
import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.constants.Routes;
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

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTests extends BaseTest {

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

        Assertions.assertNotNull(users, "Need at least one User on DB.");

        if (users.size() > 0) {
            user = users.get(0);
        }

        UUID id = user.getId();

        final String requestUrl = "http://localhost:" + randomServerPort + "/api/user/" + id;

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);

        Assertions.assertEquals(201, result.getStatusCode().value(), "User founded");

    }

    @Test
    public void testSaveUser() {
        final String requestUrl = "http://localhost:" + randomServerPort + Routes.USER;

        UserCreationTO userCreationTO = new UserCreationTO();
        userCreationTO.setName("jojo");
        userCreationTO.setEmail("jojo@gmail.com");
        userCreationTO.setPassword("12345678");

        HttpEntity<Object> request = new HttpEntity<>(userCreationTO, getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.postForEntity(requestUrl, request, String.class);

        Assertions.assertEquals(200, result.getStatusCode().value(), "User created Created");
    }
}