package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.model.Wallet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IWalletService {
    List<Wallet> findAll();

    Optional<Wallet> findById(UUID idWallet);

    void save(Wallet wallet);

    void deleteById(UUID idWallet);
}
