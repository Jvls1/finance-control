package com.jvls.financialcontrol.repositories;

import org.springframework.stereotype.Repository;

import com.jvls.financialcontrol.entities.Expense;
import com.jvls.financialcontrol.repositories.generic.IGenericRepository;

@Repository
public interface ICategoryRepository extends IGenericRepository<Expense> {

}
