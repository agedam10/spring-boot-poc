package com.minet.demo.controller;

import com.minet.demo.dao.WalletRepository;
import com.minet.demo.entity.Wallet;
import com.minet.demo.service.WalletService;
import com.minet.demo.service.WalletServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WalletController {
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallet")
    public void updateWallet(@RequestBody Wallet wallet) {
        wallet.setId(0);
        walletService.saveOrUpdateWallet(wallet.getRunningBalance(), wallet.getCustomerId());
    }

    @GetMapping("/wallet/{customerId}")
    public Wallet getWalletByCustomerId(@PathVariable int customerId) {
        return walletService.findWalletByCustomerId(customerId);
    }

}
