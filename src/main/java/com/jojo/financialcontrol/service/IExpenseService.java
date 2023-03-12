package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;
import com.jojo.financialcontrol.to.ExpenseCreationTO;

public interface IExpenseService extends IGenericCrudService<Expense> {

    void save(ExpenseCreationTO expenseCreationTO) throws InfoNotFoundException;
}
