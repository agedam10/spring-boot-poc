package com.minet.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "watchlist")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "asset_id")
    private int assetId;

    @Column(name = "customer_id")
    private int customerId;

    @Override
    public String toString() {
        return "Watchlist{" +
                "id=" + id +
                ", assetId=" + assetId +
                ", customerId=" + customerId +
                '}';
    }
}
