package com.jojo.financialcontrol.web.services;

import com.jojo.financialcontrol.infra.exception.InfoNotFoundException;
import com.jojo.financialcontrol.domain.Income;
import com.jojo.financialcontrol.web.model.IncomeCreationTO;
import com.jojo.financialcontrol.web.services.generic.IGenericCrudService;

public interface IIncomeService extends IGenericCrudService<Income> {

    void save(IncomeCreationTO incomeCreationTO) throws InfoNotFoundException;
    
}
