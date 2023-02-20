package com.minet.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "asset_id")
    private int assetId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_fee")
    private float transactionFee;

    @Column(name = "transaction_amount")
    private float transactionAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "from_Account")
    private int fromAccount;

    @Column(name = "to_account")
    private int toAccount;

    @Column(name = "conversion_factor")
    private float conversionFactor;

    @Column(name = "converted_amount")
    private float convertedAmount;


    public void setConvertedAmount(float convertedAmount) {
        this.convertedAmount = convertedAmount * getConversionFactor();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", assetId=" + assetId +
                ", transactionType='" + transactionType + '\'' +
                ", transactionFee=" + transactionFee +
                ", transactionAmount=" + transactionAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", date=" + date +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", conversionFactor=" + conversionFactor +
                ", convertedAmount=" + convertedAmount +
                '}';
    }
}
