package com.minet.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_value")
    private float assetValue;

    @Column(name = "image")
    private String image;

    @Column(name = "market_capital")
    private float marketCapital;

    @Column(name = "volume_traded")
    private float volumeTraded;

    @Column(name = "circulating_supply")
    private float circulatingSupply;

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", assetName='" + assetName + '\'' +
                ", assetValue=" + assetValue +
                ", image='" + image + '\'' +
                ", marketCapital=" + marketCapital +
                ", volumeTraded=" + volumeTraded +
                ", circulatingSupply=" + circulatingSupply +
                '}';
    }
}
