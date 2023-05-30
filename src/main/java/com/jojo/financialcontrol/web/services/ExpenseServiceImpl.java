package com.jojo.financialcontrol.web.services;

import com.jojo.financialcontrol.domain.EnumBuyMethod;
import com.jojo.financialcontrol.infra.exception.InfoNotFoundException;
import com.jojo.financialcontrol.domain.Expense;
import com.jojo.financialcontrol.domain.Wallet;
import com.jojo.financialcontrol.web.model.ExpenseCreationTO;
import com.jojo.financialcontrol.web.model.ExpenseResponseTO;
import com.jojo.financialcontrol.web.repositories.IExpenseRepository;
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
public class ExpenseServiceImpl implements IExpenseService {

    private final IExpenseRepository iExpenseRepository;

    private final SessionServiceImpl sessionService;

    private final WalletServiceImpl walletService;

    @Override
    @Deprecated
    public Page<Expense> findAll(Integer page, Integer row) {
        return iExpenseRepository.findAllByWalletWalletOwnerId(PageRequest.of(page, row), sessionService.sessionUser().getId());
    }

    @Override
    public Page<ExpenseResponseTO> findAllExpense(Integer page, Integer row) {
        Page<Expense> expensePage = iExpenseRepository.findAllByWalletWalletOwnerId(PageRequest.of(page, row), sessionService.sessionUser().getId());

        List<ExpenseResponseTO> expenseResponseTOS = expensePage.getContent()
                .stream()
                .map(expense -> new ExpenseResponseTO().setValues(expense))
                .collect(Collectors.toList());

        return new PageImpl<>(expenseResponseTOS);
    }

    @Override
    @Deprecated
    public Optional<Expense> findById(UUID idExpense) {
        return iExpenseRepository.findByIdAndWalletWalletOwnerId(idExpense, sessionService.sessionUser().getId());
    }

    @Override
    public Optional<ExpenseResponseTO> findByIdExpense(UUID idExpense) {
        Optional<Expense> expenseOpt = iExpenseRepository.findByIdAndWalletWalletOwnerId(idExpense, sessionService.sessionUser().getId());
        if (expenseOpt.isEmpty()) {
            return Optional.empty();
        }
        ExpenseResponseTO expenseResponseTO = new ExpenseResponseTO();
        expenseResponseTO.setValues(expenseOpt.get());
        return Optional.of(expenseResponseTO);
    }

    @Override
    public void save(Expense expense) {
        expense.setDateRegister(LocalDate.now());
        expense.setEnumBuyMethod(EnumBuyMethod.CASH);
        iExpenseRepository.save(expense);
    }

    @Override
    public void save(ExpenseCreationTO expenseCreationTO) throws InfoNotFoundException {
        Optional<Wallet> walletOptional = walletService.findById(expenseCreationTO.getIdWallet());
        if (walletOptional.isEmpty()) {
            throw new InfoNotFoundException("Wallet not found");
        }
        Expense expense = new Expense();
        expense.setAmount(expenseCreationTO.getAmount());
        expense.setDescription(expenseCreationTO.getDescription());
        expense.setDateRegister(LocalDate.now());
        expense.setWallet(walletOptional.get());
        expense.setEnumBuyMethod(expenseCreationTO.getEnumBuyMethod());

        iExpenseRepository.save(expense);
    }

    @Override
    public void deleteById(UUID idExpense) {
        iExpenseRepository.deleteByExpenseId(idExpense);
    }
}
