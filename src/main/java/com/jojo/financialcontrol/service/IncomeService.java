package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Income;
import com.jojo.financialcontrol.repository.IIncomeRepository;
import com.jojo.financialcontrol.service.generic.AGenericService;
import org.springframework.stereotype.Service;

@Service
public class IncomeService extends AGenericService<Income> {

    private IIncomeRepository incomeRepository;

    protected IncomeService(IIncomeRepository IIncomeRepository) {
        super(IIncomeRepository);
    }

}
