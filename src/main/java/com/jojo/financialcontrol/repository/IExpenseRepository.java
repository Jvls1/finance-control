package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

@Repository
public interface IExpenseRepository extends IGenericRepository<Expense> {

    List<Expense> findExpensesByWalletId(UUID idWallet);
}
