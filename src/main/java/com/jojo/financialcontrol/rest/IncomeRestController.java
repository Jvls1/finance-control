package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.service.IncomeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class IncomeRestController {

    private final IncomeServiceImpl incomeService;

    @GetMapping("/incomes")
    public ResponseEntity<Object> findAll() {
        try {
            List<Income> incomes = incomeService.findAll();
            return new ResponseEntity<>(incomes, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @GetMapping("/incomes/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idIncome) {
        try {
            Optional<Income> income = incomeService.findById(idIncome);
            if (income.isEmpty()) {
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(income.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @PostMapping("/incomes")
    public ResponseEntity<Object> save(@RequestBody Income incomeParam) {
        try {
            incomeService.save(incomeParam);
            return ResponseEntity.ok("Created");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @DeleteMapping("/incomes/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idIncome) {
        try {
            incomeService.deleteById(idIncome);
            return ResponseEntity.ok("Deleted");
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }
}
