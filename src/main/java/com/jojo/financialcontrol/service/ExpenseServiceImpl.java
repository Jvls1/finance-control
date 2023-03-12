package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.AuthenticationNotFoundException;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.IExpenseRepository;
import com.jojo.financialcontrol.to.ExpenseCreationTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {

    private final IExpenseRepository iExpenseRepository;

    private final SessionServiceImpl sessionService;

    private final WalletServiceImpl walletService;

    @Override
    public List<Expense> findAll() {
        return iExpenseRepository.findAll();
    }

    @Override
    public Optional<Expense> findById(UUID idExpense) {
        return iExpenseRepository.findById(idExpense);
    }

    @Override
    public void save(Expense expense) {
        expense.setDateRegister(LocalDate.now());
        expense.setEnumBuyMethod(EnumBuyMethod.CASH);
        iExpenseRepository.save(expense);
    }

    @Override
    public void save(ExpenseCreationTO expenseCreationTO) throws InfoNotFoundException {
        Expense expense = new Expense();
        expense.setDescription(expenseCreationTO.getDescription());
        expense.setDateRegister(LocalDate.now());
        expense.setUser(sessionService.sessionUser());
        Optional<Wallet> walletOptional = walletService.findById(expenseCreationTO.getIdWallet());
        if(walletOptional.isEmpty()) {
            throw new InfoNotFoundException("Wallet not found");
        }
        expense.setWallet(walletOptional.get());
        expense.setEnumBuyMethod(expenseCreationTO.getEnumBuyMethod());
        iExpenseRepository.save(expense);
    }

    @Override
    public void deleteById(UUID idExpense) {
        iExpenseRepository.deleteById(idExpense);
    }
}
