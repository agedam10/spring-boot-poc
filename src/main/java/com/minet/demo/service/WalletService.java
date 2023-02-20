package com.minet.demo.service;

import com.minet.demo.entity.Wallet;


public interface WalletService {
    public Wallet findWalletByCustomerId(int customerId);
    void saveOrUpdateWallet(float amount, int id);
}
