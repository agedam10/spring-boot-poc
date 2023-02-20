package com.minet.demo.service;

import com.minet.demo.dao.AssetRepository;
import com.minet.demo.entity.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService{
    private final AssetRepository assetRepository;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(int assetId) {
        return assetRepository.findAssetById(assetId);
    }

}
