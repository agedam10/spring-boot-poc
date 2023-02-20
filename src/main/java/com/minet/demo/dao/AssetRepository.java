package com.minet.demo.dao;

import com.minet.demo.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset,Integer> {
    public Asset findAssetById(int assetId);
}
