package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.Income;
import com.jojo.financialcontrol.repository.IIncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IIncomeService {

    private final IIncomeRepository iIncomeRepository;

    @Override
    public List<Income> findAll() {
        return iIncomeRepository.findAll();
    }

    @Override
    public Optional<Income> findById(UUID idIncome) {
        return iIncomeRepository.findById(idIncome);
    }

    @Override
    public void save(Income income) {
        iIncomeRepository.save(income);
    }

    @Override
    public void deleteById(UUID income) {
        iIncomeRepository.deleteById(income);
    }
}
