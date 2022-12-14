package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.Income;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.IncomeServiceImpl;
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
public class IncomeRestController {

    private final IncomeServiceImpl incomeService;

//    @GetMapping("/incomes")
//    List<Income> findAll() {
//        return incomeService.findAll();
//    }
//
//    @GetMapping("/incomes/{id}")
//    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idIncome) {
//        Optional<Income> income = incomeService.findById(idIncome);
//
//        return ResponseHandler.getResponse(income);
//    }
//
//    @PostMapping("/incomes")
//    public ResponseEntity<Object> save(@RequestBody Income incomeParam) {
//        if (incomeParam != null) {
//            if (incomeParam.getDescription() != null && incomeParam.getAmount() != null) {
//                incomeParam.setDateRegister(LocalDate.now());
//                incomeService.save(incomeParam);
//            }
//        }
//        return ResponseHandler.saveResponse(incomeParam);
//    }
//
//    @DeleteMapping("/incomes/{id}")
//    public void deleteById(@PathVariable("id") UUID idIncome) {
//        incomeService.deleteById(idIncome);
//    }
}
