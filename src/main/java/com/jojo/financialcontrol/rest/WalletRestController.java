package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.Wallet;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.WalletServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class WalletRestController {

    private final WalletServiceImpl walletService;

//    @GetMapping("/wallets")
//    List<Wallet> findAll() {
//        return walletService.findAll();
//    }
//
//    @GetMapping("/wallets/{id}")
//    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idIncome) {
//        Optional<Wallet> income = walletService.findById(idIncome);
//
//        return ResponseHandler.getResponse(income);
//    }
//
//    @PostMapping("/wallets")
//    public ResponseEntity<Object> save(@RequestBody Wallet walletParam) {
//        if (walletParam != null) {
//            walletService.save(walletParam);
//        }
//        return ResponseHandler.saveResponse(walletParam);
//    }
//
//    @DeleteMapping("/wallets/{id}")
//    public void deleteById(@PathVariable("id") UUID idIncome) {
//        walletService.deleteById(idIncome);
//    }
}
