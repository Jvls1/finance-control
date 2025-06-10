package com.jojo.financialcontrol.controller;


import com.jojo.financialcontrol.constants.Routes;
import com.jojo.financialcontrol.dto.ExpenseCreationDTO;
import com.jojo.financialcontrol.dto.ExpenseResponseDTO;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.service.ExpenseServiceImpl;
import com.jojo.financialcontrol.utils.URIUtil;

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

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ExpenseCreationDTO expenseParam) throws InfoNotFoundException {
        var expense = expenseService.save(expenseParam);
        return ResponseEntity.created(URIUtil.getUri(expense.getId())).build();
    }

    @GetMapping
    public ResponseEntity<Page<ExpenseResponseDTO>> findAll(@RequestParam Integer page, @RequestParam Integer row) {
        return new ResponseEntity<>(expenseService.findAllExpense(page, row), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDTO> getExpenseById(@PathVariable("id") UUID idExpense) throws InfoNotFoundException {
        Optional<ExpenseResponseDTO> expense = expenseService.findByIdExpense(idExpense);
        if (expense.isEmpty()) {
            throw new InfoNotFoundException("Expense not found");
        }
        return ResponseEntity.ok(expense.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idExpense) {
        expenseService.deleteById(idExpense);
        return ResponseEntity.noContent().build();
    }
}
