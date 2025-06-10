package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.dto.IncomeCreationDTO;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;

public interface IIncomeService extends IGenericCrudService<Income> {

    Income save(IncomeCreationDTO incomeCreationTO) throws InfoNotFoundException;
    
}
