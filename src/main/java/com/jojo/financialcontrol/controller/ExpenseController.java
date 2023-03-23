package com.jojo.financialcontrol.controller;


import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Expense;
import com.jojo.financialcontrol.model.to.ExpenseCreationTO;
import com.jojo.financialcontrol.service.ExpenseServiceImpl;
import com.jojo.financialcontrol.constants.Routes;
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
    public ResponseEntity<Page<Expense>> findAll(@RequestParam Integer page, @RequestParam Integer row) {
        return new ResponseEntity<>(expenseService.findAll(page, row), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idExpense) {
        Optional<Expense> expense = expenseService.findById(idExpense);
        if (expense.isEmpty()) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
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
