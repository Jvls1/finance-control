package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.IWalletRepository;
import com.jojo.financialcontrol.model.to.WalletCreationTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements IWalletService {

    private final IWalletRepository iWalletRepository;

    private final IUserService iUserService;

    private final ISessionService sessionService;

    @Override
    public Page<Wallet> findAll(Integer page, Integer row) {
        return iWalletRepository.findAll(PageRequest.of(page, row));
    }

    public List<Wallet> findAllWalletsOwner() {
        return iWalletRepository.findAllByWalletOwnerId(sessionService.sessionUser().getId());
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
        if (walletCreationTO.getIdWalletCollaborator() != null) {
            Optional<User> userCollaboratorOptional = iUserService.findById(walletCreationTO.getIdWalletCollaborator());
            if (userCollaboratorOptional.isEmpty()) {
                throw new InfoNotFoundException("Collaborator user dont exists");
            }
            wallet.setWalletCollaborator(userCollaboratorOptional.get());
        }
        wallet.setMonth(walletCreationTO.getMonth());
        wallet.setYear(walletCreationTO.getYear());

        wallet.setWalletOwner(userOwnerOptional.get());
        iWalletRepository.save(wallet);
    }

    @Override
    public void deleteById(UUID idWallet) {
        iWalletRepository.deleteById(idWallet);
    }

    public void addCollaboratorToWallet(UUID idWallet, UUID idUser) throws InfoNotFoundException {
        Optional<Wallet> walletOptional = iWalletRepository.findById(idWallet);
        if (walletOptional.isEmpty()) {
            throw new InfoNotFoundException("Wallet not found");
        }
        Optional<User> userOptional = iUserService.findById(idUser);
        if (userOptional.isEmpty()) {
            throw new InfoNotFoundException("User not found");
        }
        walletOptional.get().setWalletCollaborator(userOptional.get());
        save(walletOptional.get());
    }
}
