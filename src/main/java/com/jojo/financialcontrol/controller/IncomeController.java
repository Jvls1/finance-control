package com.jojo.financialcontrol.controller;


import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.service.IncomeServiceImpl;
import com.jojo.financialcontrol.utils.Routes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Routes.INCOME)
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeServiceImpl incomeService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<Income> incomes = incomeService.findAll();
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idIncome) {
        Optional<Income> income = incomeService.findById(idIncome);
        if (income.isEmpty()) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(income.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Income incomeParam) {
        incomeService.save(incomeParam);
        return ResponseEntity.ok("Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idIncome) {
        incomeService.deleteById(idIncome);
        return ResponseEntity.ok("Deleted");
    }
}
