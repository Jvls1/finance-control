package com.jojo.financialcontrol.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.IWalletRepository;
import com.jojo.financialcontrol.to.WalletCreationTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements IWalletService {

    private final IWalletRepository iWalletRepository;

    private final IUserService iUserService;

    @Override
    public List<Wallet> findAll() {
        return iWalletRepository.findAll();
    }

    @Override
    public Optional<Wallet> findById(UUID idWallet) {
        return iWalletRepository.findById(idWallet);
    }

    @Override
    public void save(Wallet wallet) {
        iWalletRepository.save(wallet);
    }

    @Override
    public void save(WalletCreationTO walletCreationTO) throws InfoNotFoundException {
        Wallet wallet = new Wallet();
        Optional<User> userOwnerOptional = iUserService.findById(walletCreationTO.getIdWalletOwner());
        if (userOwnerOptional.isEmpty()) {
            throw new InfoNotFoundException("Owner user dont exists");
        }
        Optional<User> userCollaboratorOptional = iUserService.findById(walletCreationTO.getIdWalletCollaborator());
        if (userCollaboratorOptional.isEmpty()) {
            throw new InfoNotFoundException("Collaborator user dont exists");
        }
        wallet.setMonth(walletCreationTO.getMonth());
        wallet.setYear(walletCreationTO.getYear());

        wallet.setWalletOwner(userOwnerOptional.get());
        wallet.setWalletCollaborator(userCollaboratorOptional.get());
        iWalletRepository.save(wallet);
    }

    @Override
    public void deleteById(UUID idWallet) {
        iWalletRepository.deleteById(idWallet);
    }
}
