package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.ExpenseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ExpenseRestController {

    private final ExpenseServiceImpl expenseService;

    @GetMapping("/expenses")
    public List<Expense> findAll() {
        return expenseService.findAll();
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idExpense) {
        Optional<Expense> expense = expenseService.findById(idExpense);

        return ResponseHandler.getResponse(expense);
    }

    @PostMapping("/expenses")
    public ResponseEntity<Object> save(@RequestBody Expense expenseParam) {
        if (expenseParam != null) {
            if (expenseParam.getDescription() != null && expenseParam.getAmount() != null) {
                expenseParam.setDateRegister(LocalDate.now());
                expenseService.save(expenseParam);
            }
        }
        return ResponseHandler.saveResponse(expenseParam);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteById(@PathVariable("id") UUID idExpense) {
        expenseService.deleteById(idExpense);
    }
}
