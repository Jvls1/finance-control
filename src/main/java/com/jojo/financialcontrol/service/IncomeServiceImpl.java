package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.repository.IIncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IIncomeService {

    private final IIncomeRepository iIncomeRepository;

    @Override
    public Page<Income> findAll(Integer page, Integer row) {
        return iIncomeRepository.findAll(PageRequest.of(page, row));
    }

    @Override
    public Optional<Income> findById(UUID idIncome) {
        return iIncomeRepository.findById(idIncome);
    }

    @Override
    public void save(Income income) {
        income.setDateRegister(LocalDate.now());
        iIncomeRepository.save(income);
    }

    @Override
    public void deleteById(UUID income) {
        iIncomeRepository.deleteById(income);
    }
}
