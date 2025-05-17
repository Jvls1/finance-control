package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.model.to.ExpenseResponseTO;
import com.jojo.financialcontrol.model.to.IncomeCreationTO;
import com.jojo.financialcontrol.model.to.IncomeResponseTO;
import com.jojo.financialcontrol.repository.IIncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IIncomeService {

    private final IIncomeRepository iIncomeRepository;

    private final ISessionService iSessionService;

    private final IWalletService iWalletService;

    @Override
    @Deprecated
    public Page<Income> findAll(Integer page, Integer row) {
        return iIncomeRepository.findAllByWalletWalletOwnerId(PageRequest.of(page, row), iSessionService.sessionUser().getId());
    }

    public Page<IncomeResponseTO> findAllIncome(Integer page, Integer row) {
        Page<Income> incomePage = iIncomeRepository.findAllByWalletWalletOwnerId(PageRequest.of(page, row), iSessionService.sessionUser().getId());

        List<IncomeResponseTO> expenseResponseTOS = incomePage.getContent()
                .stream()
                .map(income -> new IncomeResponseTO().setValues(income))
                .collect(Collectors.toList());

        return new PageImpl<>(expenseResponseTOS);
    }

    @Override
    @Deprecated
    public Optional<Income> findById(UUID idIncome) {
        return iIncomeRepository.findByIdAndWalletWalletOwnerId(idIncome, iSessionService.sessionUser().getId());
    }

    public Optional<IncomeResponseTO> findByIdIncome(UUID idIncome) throws InfoNotFoundException {
        Optional<Income> incomeOpt = iIncomeRepository.findByIdAndWalletWalletOwnerId(idIncome, iSessionService.sessionUser().getId());
        if(incomeOpt.isEmpty()) {
            return Optional.empty();
        }
        IncomeResponseTO incomeResponseTO = new IncomeResponseTO();
        incomeResponseTO.setValues(incomeOpt.get());
        return Optional.of(incomeResponseTO);
    }

    @Override
    public void save(Income income) {
        income.setDateRegister(LocalDate.now());
        iIncomeRepository.save(income);
    }

    @Override
    public void save(IncomeCreationTO incomeCreationTO) throws InfoNotFoundException {
        Optional<Wallet> walletOptional = iWalletService.findById(incomeCreationTO.getIdWallet());
        if (walletOptional.isEmpty()) {
            throw new InfoNotFoundException("Wallet not found");
        }
        Income income = new Income();
        income.setDescription(incomeCreationTO.getDescription());
        income.setAmount(incomeCreationTO.getAmount());
        income.setDateRegister(LocalDate.now());
        income.setWallet(walletOptional.get());

        iIncomeRepository.save(income);
    }

    @Override
    public void deleteById(UUID income) {
        iIncomeRepository.deleteByIncomeId(income);
    }
}
