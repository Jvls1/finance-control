package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.to.WalletCreationTO;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IWalletService {
    List<Wallet> findAll();

    Optional<Wallet> findById(UUID idWallet);

    void save(WalletCreationTO wallet) throws HttpClientErrorException.NotFound, InfoNotFoundException;

    void save(Wallet wallet);

    void deleteById(UUID idWallet);
}
