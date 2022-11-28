package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.repository.IIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IIncomeService {

    @Autowired
    IIncomeRepository iIncomeRepository;
}
