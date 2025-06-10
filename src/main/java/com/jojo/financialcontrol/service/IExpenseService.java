package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.dto.ExpenseCreationDTO;
import com.jojo.financialcontrol.dto.ExpenseResponseDTO;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;

import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface IExpenseService extends IGenericCrudService<Expense> {

    Page<ExpenseResponseDTO> findAllExpense(Integer page, Integer row);

    Optional<ExpenseResponseDTO> findByIdExpense(UUID idEntity) throws InfoNotFoundException;

    Expense save(ExpenseCreationDTO expenseCreationTO) throws InfoNotFoundException;
}
