package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.repository.IExpenseRepository;
import com.jojo.financialcontrol.service.generic.AGenericService;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService extends AGenericService<Expense> {

    protected ExpenseService(IExpenseRepository expenseRepository) {
        super(expenseRepository);
    }
}
