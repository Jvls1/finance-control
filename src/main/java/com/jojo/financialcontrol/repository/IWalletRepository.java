package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWalletRepository extends IGenericRepository<Wallet> {

}
