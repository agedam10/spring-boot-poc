package com.minet.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "portfolio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "asset_id")
    private int assetId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "asset_amount")
    private float assetAmount;

    @Column(name = "converted_amount")
    private float convertedAmount;

    @Column(name = "conversion_factor")
    private float conversionFactor;

    public void setConvertedAmount(float assetAmount) {
        this.convertedAmount = assetAmount * conversionFactor;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", assetId=" + assetId +
                ", customerId=" + customerId +
                ", assetAmount=" + assetAmount +
                ", convertedAmount=" + convertedAmount +
                ", conversionFactor=" + conversionFactor +
                '}';
    }
}
