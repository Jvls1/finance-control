package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.model.to.IncomeCreationTO;
import com.jojo.financialcontrol.repository.IIncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IIncomeService {

    private final IIncomeRepository iIncomeRepository;

    private final ISessionService iSessionService;

    private final IWalletService iWalletService;

    @Override
    public Page<Income> findAll(Integer page, Integer row) {
        return iIncomeRepository.findAllByWalletWalletOwnerId(PageRequest.of(page, row), iSessionService.sessionUser().getId());
    }

    @Override
    public Optional<Income> findById(UUID idIncome) {
        return iIncomeRepository.findByIdAndWalletWalletOwnerId(idIncome, iSessionService.sessionUser().getId());
    }

    @Override
    public void save(Income income) {
        income.setDateRegister(LocalDate.now());
        iIncomeRepository.save(income);
    }

    @Override
    public void save(IncomeCreationTO incomeCreationTO) throws InfoNotFoundException {
        Optional<Wallet> walletOptional = iWalletService.findById(incomeCreationTO.getIdWallet());

        if (walletOptional.isEmpty())
            throw new InfoNotFoundException("Wallet not found");

        Income income = new Income();
        income.setDescription(incomeCreationTO.getDescription());
        income.setAmount(incomeCreationTO.getAmount());
        income.setDateRegister(incomeCreationTO.getDateRegister());
        income.setWallet(walletOptional.get());

        iIncomeRepository.save(income);
    }

    @Override
    public void deleteById(UUID income) {
        iIncomeRepository.deleteById(income);
    }
}
