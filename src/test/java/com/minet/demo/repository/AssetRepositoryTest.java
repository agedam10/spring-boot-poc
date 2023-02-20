package com.minet.demo.repository;

import com.minet.demo.dao.AssetRepository;
import com.minet.demo.entity.Asset;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AssetRepositoryTest {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAssetByIdTest() {
        Asset asset = Asset.builder()
                .assetName("degecoin")
                .image("doge.png")
                .assetValue(2332.11F)
                .marketCapital(323.111F)
                .volumeTraded(2321.111F)
                .build();
        entityManager.persist(asset);
        entityManager.flush();
        Assertions.assertEquals(assetRepository.findAssetById(1).getId(), 1);
    }
}
