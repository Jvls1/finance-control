package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Income;

import java.util.List;
import java.util.Optional;

public interface IIncomeService {
    List<Income> findAll();

    Optional<Income> findById(Integer idExpense);

    void save(Income expense);

    void deleteById(Integer idExpense);
}
