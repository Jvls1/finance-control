package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Expense;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IExpenseService {

    List<Expense> findAll();

    Optional<Expense> findById(UUID idExpense);

    void save(Expense expense);

    void deleteById(UUID idExpense);
}
