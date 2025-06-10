package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.dto.ExpenseCreationDTO;
import com.jojo.financialcontrol.dto.ExpenseResponseDTO;
import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.IExpenseRepository;
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
    public Page<ExpenseResponseDTO> findAllExpense(Integer page, Integer row) {
        Page<Expense> expensePage = iExpenseRepository.findAllByWalletWalletOwnerId(PageRequest.of(page, row), sessionService.sessionUser().getId());

        List<ExpenseResponseDTO> expenseResponseTOS = expensePage.getContent()
                .stream()
                .map(expense -> new ExpenseResponseDTO().setValues(expense))
                .collect(Collectors.toList());

        return new PageImpl<>(expenseResponseTOS);
    }

    @Override
    @Deprecated
    public Optional<Expense> findById(UUID idExpense) {
        return iExpenseRepository.findByIdAndWalletWalletOwnerId(idExpense, sessionService.sessionUser().getId());
    }

    @Override
    public Optional<ExpenseResponseDTO> findByIdExpense(UUID idExpense) {
        Optional<Expense> expenseOpt = iExpenseRepository.findByIdAndWalletWalletOwnerId(idExpense, sessionService.sessionUser().getId());
        if (expenseOpt.isEmpty()) {
            return Optional.empty();
        }
        ExpenseResponseDTO expenseResponseTO = new ExpenseResponseDTO();
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
    public Expense save(ExpenseCreationDTO expenseCreationTO) throws InfoNotFoundException {
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

        return iExpenseRepository.save(expense);
    }

    @Override
    public void deleteById(UUID idExpense) {
        iExpenseRepository.deleteByExpenseId(idExpense);
    }
}
