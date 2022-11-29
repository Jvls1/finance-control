package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.repository.IExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements IExpenseService {

    @Autowired
    IExpenseRepository iExpenseRepository;

    @Override
    public List<Expense> findAll() {
        return iExpenseRepository.findAll();
    }

    @Override
    public Optional<Expense> findById(Integer idExpense) {
        return iExpenseRepository.findById(idExpense);
    }

    @Override
    public void save(Expense expense) {
        iExpenseRepository.save(expense);
    }

    @Override
    public void deleteById(Integer idExpense) {
        iExpenseRepository.deleteById(idExpense);
    }
}
