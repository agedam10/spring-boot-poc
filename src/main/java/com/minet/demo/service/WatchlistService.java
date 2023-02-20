package com.minet.demo.service;

import com.minet.demo.entity.Watchlist;

import java.util.List;

public interface WatchlistService {
    public List<Watchlist> findByCustomerId(int customerId);

    public void addToWatchlist(Watchlist watchlist);

    public void removeFromWatchList(int id);
}
