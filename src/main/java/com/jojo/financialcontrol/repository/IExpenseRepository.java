package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IExpenseRepository extends IGenericRepository<Expense> {

    Page<Expense> findAllByWalletWalletOwnerId(Pageable page, UUID idUserOwner);

    Optional<Expense> findByIdAndWalletWalletOwnerId(UUID idExpense, UUID idUserOwner);
}
