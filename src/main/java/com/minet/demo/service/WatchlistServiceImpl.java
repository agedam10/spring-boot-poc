package com.minet.demo.service;

import com.minet.demo.dao.WatchlistRepository;
import com.minet.demo.entity.Watchlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService{
    private final WatchlistRepository watchlistRepository;

    @Autowired
    public WatchlistServiceImpl(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }


    @Override
    public List<Watchlist> findByCustomerId(int customerId) {
        return watchlistRepository.findByCustomerId(customerId);
    }

    @Override
    public void addToWatchlist(Watchlist watchlist) {
        watchlistRepository.save(watchlist);
    }

    @Override
    public void removeFromWatchList(int id) {
        watchlistRepository.deleteById(id);
    }
}
