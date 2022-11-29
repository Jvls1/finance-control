package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface IExpenseService {

    List<Expense> findAll();

    Optional<Expense> findById(Integer idExpense);

    void save(Expense expense);

    void deleteById(Integer idExpense);
}
