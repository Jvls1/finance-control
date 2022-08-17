package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.entity.Income;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ExpenseRestController {

    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    List<Expense> findAll() {
        return expenseService.findAll();
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") Integer idExpense) {
        Optional<Expense> expense = expenseService.findById(idExpense);

        return ResponseHandler.getResponse(expense);
    }

    @PostMapping("/expenses")
    private ResponseEntity<Object> save(@RequestBody Expense expenseParam) {
        if (expenseParam != null) {
            if (expenseParam.getDescription() != null && expenseParam.getAmount() != null) {
                expenseParam.setRegisterDate(LocalDate.now());
                expenseService.save(expenseParam);
            }
        }
        return ResponseHandler.saveResponse(expenseParam);
    }

    @DeleteMapping("/expenses/{id}")
    private void deleteById(@PathVariable("id") Integer idExpense) {
        expenseService.deleteById(idExpense);
    }
}
