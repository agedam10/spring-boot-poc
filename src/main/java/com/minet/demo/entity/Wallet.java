package com.minet.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "running_balance")
    private float runningBalance;

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", runningBalance=" + runningBalance +
                '}';
    }
}
