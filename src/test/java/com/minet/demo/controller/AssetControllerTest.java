package com.minet.demo.controller;

import com.minet.demo.entity.Asset;
import com.minet.demo.service.AssetService;
import com.minet.demo.service.AssetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AssetController.class)
public class AssetControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssetServiceImpl assetService;

    @Test
    public void testGetAllAssets() {
        Asset asset = Asset.builder()
                .assetName("degecoin")
                .image("doge.png")
                .assetValue(2332.11F)
                .marketCapital(323.111F)
                .volumeTraded(2321.111F)
                .circulatingSupply(23.133F)
                .build();

        List<Asset> assets = new ArrayList<>();
        assets.add(asset);
        given(assetService.findAll()).willReturn(assets);
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/assets")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect((ResultMatcher) jsonPath("$[0].assetName").value(asset.getAssetName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetAssetById() {
        Asset asset = Asset.builder()
                .assetName("degecoin")
                .image("doge.png")
                .assetValue(2332.11F)
                .marketCapital(323.111F)
                .volumeTraded(2321.111F)
                .circulatingSupply(12121.21F)
                .id(1)
                .build();
        List<Asset> assetList = new ArrayList<>();
        assetList.add(asset);
        given(assetService.getAssetById(1)).willReturn(assetList.get(0));
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/assets/1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$.id").value(asset.getId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
