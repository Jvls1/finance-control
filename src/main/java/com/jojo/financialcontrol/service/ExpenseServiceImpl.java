package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.repository.IExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {

    private final IExpenseRepository iExpenseRepository;

    @Override
    public List<Expense> findAll() {
        return iExpenseRepository.findAll();
    }

    @Override
    public Optional<Expense> findById(UUID idExpense) {
        return iExpenseRepository.findById(idExpense);
    }

    @Override
    public void save(Expense expense) {
        expense.setDateRegister(LocalDate.now());
        expense.setEnumBuyMethod(EnumBuyMethod.CASH);
        iExpenseRepository.save(expense);
    }

    @Override
    public void deleteById(UUID idExpense) {
        iExpenseRepository.deleteById(idExpense);
    }
}
