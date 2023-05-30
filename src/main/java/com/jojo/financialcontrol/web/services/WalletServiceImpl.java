package com.jojo.financialcontrol.web.services;

import com.jojo.financialcontrol.infra.exception.InfoNotFoundException;
import com.jojo.financialcontrol.domain.User;
import com.jojo.financialcontrol.domain.Wallet;
import com.jojo.financialcontrol.web.model.WalletCreationTO;
import com.jojo.financialcontrol.web.repositories.IWalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements IWalletService {

    private final IWalletRepository iWalletRepository;

    private final IUserService iUserService;

    private final ISessionService sessionService;

    @Override
    public Page<Wallet> findAll(Integer page, Integer row) {
        return iWalletRepository.findAll(PageRequest.of(page, row));
    }

    public Page<Wallet> findAllWalletsByOwner(Pageable pageable) {
        return iWalletRepository.findAllByWalletOwnerIdOrWalletCollaboratorId(pageable, sessionService.sessionUser().getId());
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
        LocalDate now = LocalDate.now();

        if (walletCreationTO.getMonth() != null) {
            wallet.setMonth(walletCreationTO.getMonth());
        } else {
            wallet.setMonth(now.getMonth());
        }
        if (walletCreationTO.getYear() != null) {
            wallet.setYear(walletCreationTO.getYear());
        } else {
            wallet.setYear(Year.now());
        }

        wallet.setWalletOwner(userOwnerOptional.get());
        iWalletRepository.save(wallet);
    }

    @Override
    public void deleteById(UUID idWallet) {
        iWalletRepository.deleteByWalletId(idWallet);
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

    public void removeCollaboratorFromWallet(UUID idWallet, UUID idUser) throws InfoNotFoundException {
        Optional<Wallet> walletOptional = iWalletRepository.findById(idWallet);
        if (walletOptional.isEmpty()) {
            throw new InfoNotFoundException("Wallet not found");
        }
        Optional<User> userOptional = iUserService.findById(idUser);
        if (userOptional.isEmpty()) {
            throw new InfoNotFoundException("User not found");
        }
        iWalletRepository.removeWalletCollaboratorByWalletIdAndUserId(idWallet, idUser);
    }

    public List<Wallet> findByWalletOwnerId(UUID idUser) {
        return iWalletRepository.findAllByWalletOwnerId(idUser);
    }

}
