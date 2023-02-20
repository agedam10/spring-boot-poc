package com.minet.demo.dao;

import com.minet.demo.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

    public List<Portfolio> getPortfoliosByCustomerId(int customerId);

    @Modifying
    @Query("update Portfolio set assetAmount = :assetAmount, convertedAmount = :convertedAmount where assetId = :assetId")
    public void updateRepository(@Param(value = "assetAmount") float assetAmount, @Param(value = "convertedAmount") float convertedAmount,@Param(value = "assetId") int assetId);
}
