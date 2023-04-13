package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.model.to.IncomeCreationTO;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;

public interface IIncomeService extends IGenericCrudService<Income> {

    void save(IncomeCreationTO incomeCreationTO) throws InfoNotFoundException;
    
}
