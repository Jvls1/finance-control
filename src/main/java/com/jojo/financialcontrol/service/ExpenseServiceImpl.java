package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.repository.IExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements IExpenseService {

    @Autowired
    IExpenseRepository iExpenseRepository;

}
