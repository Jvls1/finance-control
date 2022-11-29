package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.entity.Income;
import com.jojo.financialcontrol.repository.IIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IIncomeService {

    @Autowired
    IIncomeRepository iIncomeRepository;

    @Override
    public List<Income> findAll() {
        return iIncomeRepository.findAll();
    }

    @Override
    public Optional<Income> findById(Integer idExpense) {
        return iIncomeRepository.findById(idExpense);
    }

    @Override
    public void save(Income expense) {
        iIncomeRepository.save(expense);
    }

    @Override
    public void deleteById(Integer idExpense) {
        iIncomeRepository.deleteById(idExpense);
    }
}
