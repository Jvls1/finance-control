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
public class WalletRestController {

    private final WalletServiceImpl walletService;

    @GetMapping("/wallets/{id}")
    public ResponseEntity<Object> getExpenseById(@PathVariable("id") UUID idWallet) {
        try {
            Optional<Wallet> wallet = walletService.findById(idWallet);
            if (wallet.isEmpty()) {
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(wallet.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }

    }

    @PostMapping("/wallets")
    public ResponseEntity<Object> save(@RequestBody Wallet walletParam) {
        try {
            walletService.save(walletParam);
            return ResponseEntity.ok("Created");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @DeleteMapping("/wallets/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idIncome) {
        try {
            walletService.deleteById(idIncome);
            return ResponseEntity.ok("Deleted");
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }
}
