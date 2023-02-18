package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.model.Income;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IIncomeService {
    List<Income> findAll();

    Optional<Income> findById(UUID idExpense);

    void save(Income expense);

    void deleteById(UUID idExpense);
}
