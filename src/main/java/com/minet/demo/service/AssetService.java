package com.minet.demo.service;

import com.minet.demo.entity.Asset;

import java.util.List;

public interface AssetService {
    public List<Asset> findAll();

    public Asset getAssetById(int assetId);

//    public Asset getAssetByName(String name);
}
