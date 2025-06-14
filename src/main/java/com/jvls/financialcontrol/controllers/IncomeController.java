package com.jvls.financialcontrol.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jvls.financialcontrol.constants.Routes;
import com.jvls.financialcontrol.dtos.IncomeCreationDTO;
import com.jvls.financialcontrol.dtos.IncomeResponseDTO;
import com.jvls.financialcontrol.exceptions.InfoNotFoundException;
import com.jvls.financialcontrol.services.IncomeServiceImpl;
import com.jvls.financialcontrol.utils.URIUtil;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Routes.INCOME)
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeServiceImpl incomeService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody IncomeCreationDTO incomeParam) throws InfoNotFoundException {
        var income = incomeService.save(incomeParam);
        return ResponseEntity.created(URIUtil.getUri(income.getId())).build();
    }

    @GetMapping
    public ResponseEntity<Page<IncomeResponseDTO>> findAll(@RequestParam Integer page, @RequestParam Integer row) {
        return new ResponseEntity<>(incomeService.findAllIncome(page, row), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeResponseDTO> getExpenseById(@PathVariable("id") UUID idIncome) throws InfoNotFoundException {
        Optional<IncomeResponseDTO> income = incomeService.findByIdIncome(idIncome);
        if (income.isEmpty()) {
            throw new InfoNotFoundException("Income not found");
        }
        return new ResponseEntity<>(income.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idIncome) {
        incomeService.deleteById(idIncome);
        return ResponseEntity.noContent().build();
    }
}
