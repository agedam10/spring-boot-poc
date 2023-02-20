package com.minet.demo.controller;

import com.minet.demo.entity.Watchlist;
import com.minet.demo.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WatchlistController {

    private WatchlistService watchlistService;

    @Autowired
    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }



    @GetMapping("/watchlist/{customerId}")
    public List<Watchlist> getWatchList(@PathVariable int customerId) {
        return watchlistService.findByCustomerId(customerId);
    }

    @PostMapping("/watchlist")
    public Watchlist addWatchlist(@RequestBody Watchlist watchlist) {
        watchlist.setId(0);
        watchlistService.addToWatchlist(watchlist);
        return watchlist;
    }

    @DeleteMapping ("/watchlist/{watchlistId}")
    public void deleteWatchlist(@PathVariable int watchlistId) {
        watchlistService.removeFromWatchList(watchlistId);
    }


}
