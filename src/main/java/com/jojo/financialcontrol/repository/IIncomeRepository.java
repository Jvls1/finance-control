package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncomeRepository extends IGenericRepository<Income> {
}
