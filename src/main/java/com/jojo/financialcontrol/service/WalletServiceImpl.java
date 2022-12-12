package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Wallet;
import com.jojo.financialcontrol.repository.IWalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements IWalletService {

    private final IWalletRepository iWalletRepository;

    @Override
    public List<Wallet> findAll() {
        return iWalletRepository.findAll();
    }

    @Override
    public Optional<Wallet> findById(UUID idWallet) {
        return iWalletRepository.findById(idWallet);
    }

    @Override
    public void save(Wallet expense) {
        iWalletRepository.save(expense);
    }

    @Override
    public void deleteById(UUID idWallet) {
        iWalletRepository.deleteById(idWallet);
    }
}
