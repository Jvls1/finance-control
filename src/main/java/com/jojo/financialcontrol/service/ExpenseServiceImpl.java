package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.model.to.ExpenseCreationTO;
import com.jojo.financialcontrol.repository.IExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {

    private final IExpenseRepository iExpenseRepository;

    private final SessionServiceImpl sessionService;

    private final WalletServiceImpl walletService;

    @Override
    public Page<Expense> findAll(Integer page, Integer row) {
        return iExpenseRepository.findAllByWalletWalletOwnerId(PageRequest.of(page, row), sessionService.sessionUser().getId());
    }

    @Override
    public Optional<Expense> findById(UUID idExpense) {
        return iExpenseRepository.findByIdAndWalletWalletOwnerId(idExpense, sessionService.sessionUser().getId());
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
        expense.setDescription(expenseCreationTO.getDescription());
        expense.setDateRegister(LocalDate.now());
        expense.setWallet(walletOptional.get());
        expense.setEnumBuyMethod(expenseCreationTO.getEnumBuyMethod());

        iExpenseRepository.save(expense);
    }

    @Override
    public void deleteById(UUID idExpense) {
        iExpenseRepository.deleteById(idExpense);
    }
}
