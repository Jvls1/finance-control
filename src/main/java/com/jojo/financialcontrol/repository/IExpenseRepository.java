package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpenseRepository extends IGenericRepository<Expense> {
}
