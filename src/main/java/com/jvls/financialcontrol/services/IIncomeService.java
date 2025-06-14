package com.jvls.financialcontrol.services;

import com.jvls.financialcontrol.dtos.IncomeCreationDTO;
import com.jvls.financialcontrol.entities.Income;
import com.jvls.financialcontrol.exceptions.InfoNotFoundException;
import com.jvls.financialcontrol.services.generic.IGenericCrudService;

public interface IIncomeService extends IGenericCrudService<Income> {

    Income save(IncomeCreationDTO incomeCreationTO) throws InfoNotFoundException;
    
}
