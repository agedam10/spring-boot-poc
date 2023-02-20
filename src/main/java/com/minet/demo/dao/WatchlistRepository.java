package com.minet.demo.dao;

import com.minet.demo.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    public List<Watchlist> findByCustomerId(int customerId);
}
