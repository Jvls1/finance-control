package com.jojo.financialcontrol.web.services;

import com.jojo.financialcontrol.infra.exception.InfoNotFoundException;
import com.jojo.financialcontrol.domain.Expense;
import com.jojo.financialcontrol.web.model.ExpenseResponseTO;
import com.jojo.financialcontrol.web.services.generic.IGenericCrudService;
import com.jojo.financialcontrol.web.model.ExpenseCreationTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface IExpenseService extends IGenericCrudService<Expense> {

    Page<ExpenseResponseTO> findAllExpense(Integer page, Integer row);

    Optional<ExpenseResponseTO> findByIdExpense(UUID idEntity) throws InfoNotFoundException;

    void save(ExpenseCreationTO expenseCreationTO) throws InfoNotFoundException;
}
