package com.jojo.financialcontrol.controller;


import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.model.to.IncomeCreationTO;
import com.jojo.financialcontrol.model.to.IncomeResponseTO;
import com.jojo.financialcontrol.service.IncomeServiceImpl;
import com.jojo.financialcontrol.constants.Routes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Routes.INCOME)
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeServiceImpl incomeService;

    @GetMapping
    public ResponseEntity<Page<IncomeResponseTO>> findAll(@RequestParam Integer page, @RequestParam Integer row) {
        return new ResponseEntity<>(incomeService.findAllIncome(page, row), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeResponseTO> getExpenseById(@PathVariable("id") UUID idIncome) throws InfoNotFoundException {
        Optional<IncomeResponseTO> income = incomeService.findByIdIncome(idIncome);
        if (income.isEmpty()) {
            throw new InfoNotFoundException("Income not found");
        }
        return new ResponseEntity<>(income.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody IncomeCreationTO incomeParam) throws InfoNotFoundException {
        incomeService.save(incomeParam);
        return ResponseEntity.ok("Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idIncome) {
        incomeService.deleteById(idIncome);
        return ResponseEntity.ok("Deleted");
    }
}
