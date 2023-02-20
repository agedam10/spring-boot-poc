package com.minet.demo.dao;

import com.minet.demo.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    public Wallet findWalletByCustomerId(int customerId);

    @Modifying
    @Query("update Wallet set runningBalance = :runningBalance where customerId = :customerId")
    public void updateWallet(@Param(value = "customerId")  int customerId, @Param(value = "runningBalance")  float runningBalance);
}
