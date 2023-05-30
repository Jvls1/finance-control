package com.jojo.financialcontrol.web.controller;


import com.jojo.financialcontrol.infra.constants.Routes;
import com.jojo.financialcontrol.infra.exception.InfoNotFoundException;
import com.jojo.financialcontrol.web.model.ExpenseCreationTO;
import com.jojo.financialcontrol.web.model.ExpenseResponseTO;
import com.jojo.financialcontrol.web.services.ExpenseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Routes.EXPENSE)
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseServiceImpl expenseService;

    @GetMapping
    public ResponseEntity<Page<ExpenseResponseTO>> findAll(@RequestParam Integer page, @RequestParam Integer row) {
        return new ResponseEntity<>(expenseService.findAllExpense(page, row), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseTO> getExpenseById(@PathVariable("id") UUID idExpense) throws InfoNotFoundException {
        Optional<ExpenseResponseTO> expense = expenseService.findByIdExpense(idExpense);
        if (expense.isEmpty()) {
            throw new InfoNotFoundException("Expense not found");
        }
        return new ResponseEntity<>(expense.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ExpenseCreationTO expenseParam) throws InfoNotFoundException {
        expenseService.save(expenseParam);
        return ResponseEntity.ok("Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idExpense) {
        expenseService.deleteById(idExpense);
        return ResponseEntity.ok("Deleted");
    }
}
