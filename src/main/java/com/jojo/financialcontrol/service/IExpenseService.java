package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.model.to.ExpenseResponseTO;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;
import com.jojo.financialcontrol.model.to.ExpenseCreationTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface IExpenseService extends IGenericCrudService<Expense> {

    Page<ExpenseResponseTO> findAllExpense(Integer page, Integer row);

    Optional<ExpenseResponseTO> findByIdExpense(UUID idEntity);

    void save(ExpenseCreationTO expenseCreationTO) throws InfoNotFoundException;
}
