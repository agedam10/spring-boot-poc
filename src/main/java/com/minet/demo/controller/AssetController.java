package com.minet.demo.controller;

import com.minet.demo.dao.AssetRepository;
import com.minet.demo.entity.Asset;
import com.minet.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AssetController {
    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping(value = "/assets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Asset> getAllAssets() {
        return assetService.findAll();
    }

    @GetMapping(value = "/assets/{assetId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Asset getAssetById(@PathVariable int assetId) {
        return assetService.getAssetById(assetId);
    }


}
