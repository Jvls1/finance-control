package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.service.WalletServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class WalletController {

    private final WalletServiceImpl walletService;

    @GetMapping("/wallets/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idWallet) {
        Optional<Wallet> wallet = walletService.findById(idWallet);
        if (wallet.isEmpty()) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(wallet.get(), HttpStatus.OK);

    }

    @PostMapping("/wallets")
    public ResponseEntity<Object> save(@RequestBody Wallet walletParam) {
        walletService.save(walletParam);
        return ResponseEntity.ok("Created");
    }

    @DeleteMapping("/wallets/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idIncome) {
        walletService.deleteById(idIncome);
        return ResponseEntity.ok("Deleted");
    }
}
