package com.jvls.financialcontrol.services;

import org.springframework.data.domain.Page;

import com.jvls.financialcontrol.dtos.ExpenseCreationDTO;
import com.jvls.financialcontrol.dtos.ExpenseResponseDTO;
import com.jvls.financialcontrol.entities.Expense;
import com.jvls.financialcontrol.exceptions.InfoNotFoundException;
import com.jvls.financialcontrol.services.generic.IGenericCrudService;

import java.util.Optional;
import java.util.UUID;

public interface IExpenseService extends IGenericCrudService<Expense> {

    Page<ExpenseResponseDTO> findAllExpense(Integer page, Integer row);

    Optional<ExpenseResponseDTO> findByIdExpense(UUID idEntity) throws InfoNotFoundException;

    Expense save(ExpenseCreationDTO expenseCreationTO) throws InfoNotFoundException;
}
