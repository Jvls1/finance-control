package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IWalletRepository extends IGenericRepository<Wallet> {

    List<Wallet> findAllByIdUser(UUID idUser);
}
