package com.minet.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "portfolio_id")
    private int portfolioId;

    @Column(name = "wallet_id")
    private int walletId;

    @Column(name = "watchlist_id")
    private int watchlistId;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", portfolioId=" + portfolioId +
                ", walletId=" + walletId +
                ", watchlistId=" + watchlistId +
                '}';
    }
}
