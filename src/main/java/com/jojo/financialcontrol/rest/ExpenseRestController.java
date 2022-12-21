package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.ExpenseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> findAll() {
        try {
            List<Expense> expenses = expenseService.findAll();
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idExpense) {
        try {
            Optional<Expense> expense = expenseService.findById(idExpense);
            if (expense.isEmpty()) {
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(expense.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @PostMapping("/expenses")
    public ResponseEntity<Object> save(@RequestBody Expense expenseParam) {
        try {
            expenseService.save(expenseParam);
            return ResponseEntity.ok("Created");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idExpense) {
        try {
            expenseService.deleteById(idExpense);
            return ResponseEntity.ok("Deleted");
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }
}
