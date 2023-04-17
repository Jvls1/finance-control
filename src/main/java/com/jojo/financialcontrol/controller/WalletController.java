package com.jojo.financialcontrol.controller;


import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.model.to.WalletCreationTO;
import com.jojo.financialcontrol.service.WalletServiceImpl;
import com.jojo.financialcontrol.constants.Routes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Routes.WALLET)
@RequiredArgsConstructor
public class WalletController {

    private final WalletServiceImpl walletService;

    @GetMapping()
    public ResponseEntity<Page<Wallet>> getWalletAll(@RequestParam Integer page, @RequestParam Integer row) throws InfoNotFoundException {
        Page<Wallet> walletPage = walletService.findAllWalletsByOwner(PageRequest.of(page, row));
        if (walletPage.isEmpty()) {
            throw new InfoNotFoundException("Wallet not found");
        }
        return new ResponseEntity<>(walletPage, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getWalletById(@PathVariable("id") UUID idWallet) {
        Optional<Wallet> wallet = walletService.findById(idWallet);
        if (wallet.isEmpty()) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(wallet.get(), HttpStatus.OK);

    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Wallet> getWalletByOwnerId(@PathVariable("id") UUID idWallet) throws InfoNotFoundException {
        Optional<Wallet> walletOptional = walletService.findByWalletOwnerId(idWallet);
        if(walletOptional.isEmpty()) {
            throw new InfoNotFoundException("Wallet not found");
        }
        return new ResponseEntity<>(walletOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createWallet(@RequestBody WalletCreationTO walletParam) throws InfoNotFoundException {
        walletService.save(walletParam);
        return ResponseEntity.ok("Created");
    }

    @PostMapping("/collaborator")
    public ResponseEntity<Object> addCollaboratorToWallet(@RequestParam UUID idWallet, @RequestParam UUID idUser)
            throws InfoNotFoundException {
        walletService.addCollaboratorToWallet(idWallet, idUser);
        return ResponseEntity.ok("Add");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") UUID idWallet) {
        walletService.deleteById(idWallet);
        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping("/collaborator")
    public ResponseEntity<Object> removeCollaboratorFromWallet(@RequestParam UUID idWallet, @RequestParam UUID idUser)
            throws InfoNotFoundException {
        walletService.removeCollaboratorFromWallet(idWallet, idUser);
        return ResponseEntity.ok("Add");
    }
}
