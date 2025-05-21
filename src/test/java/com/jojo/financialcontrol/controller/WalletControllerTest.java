package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.constants.Routes;
import com.jojo.financialcontrol.dto.WalletCreationDTO;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.IWalletRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

public class WalletControllerTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private IWalletRepository iWalletRepository;

    @Test
    void getWalletById() {
        Page<Wallet> wallets = iWalletRepository.findAll(PageRequest.of(1, 1));

        List<Wallet> walletList = wallets.getContent();

        Assertions.assertNotNull(walletList, "Need at least one Wallet on DB.");

        Wallet wallet = new Wallet();
        if (walletList.size() > 0) {
            wallet = walletList.get(0);
        }

        UUID id = wallet.getId();

        final String requestUrl = "http://localhost:" + randomServerPort + Routes.WALLET + "/" + id;

        HttpEntity<Object> request = new HttpEntity<>(getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, String.class);

        Assertions.assertEquals(201, result.getStatusCode().value(), "User founded");
    }

    @Test
    void save() {
        final String requestUrl = "http://localhost:" + randomServerPort + Routes.WALLET;

        WalletCreationDTO walletCreationTO = new WalletCreationDTO();
        walletCreationTO.setIdWalletCollaborator(new UUID(1,1));
        walletCreationTO.setIdWalletOwner(new UUID(1,1));
        walletCreationTO.setYear(Year.now());
        walletCreationTO.setMonth(Month.JANUARY);

        HttpEntity<Object> request = new HttpEntity<>(walletCreationTO, getJwtAuthenticationHeader());

        ResponseEntity<String> result = restTemplate.postForEntity(requestUrl, request, String.class);

        Assertions.assertEquals(200, result.getStatusCode().value());
    }

    @Test
    void deleteById() {
    }
}