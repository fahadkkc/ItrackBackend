package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.model.WatchlistProfile;
import com.example.ItrackBackend.model.dtos.WatchlistProfileDto;
import com.example.ItrackBackend.model.dynamicParams.WatchListedProfileDynamicParams;
import com.example.ItrackBackend.service.WatchlistProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WatchlistProfileController {
    private final WatchlistProfileService watchlistProfileService;

    @GetMapping("/watchlist-profile")
    WatchlistProfile getWatchlistProfile(@RequestParam("id") String id) {
        return watchlistProfileService.getWatchlistProfile(id);

    }

    @PutMapping("/watchlist-profile")
    WatchlistProfile updateWatchlistProfile(@RequestParam("id") String id, @RequestBody WatchlistProfileDto request) {
        return watchlistProfileService.updateWatchlistProfile(id, request);
    }

    @GetMapping("/list-watchlist-profile")
    List<WatchlistProfile> listWatchlistProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
        return watchlistProfileService.listWatchlistProfile(pageNo, pageLimit);

    }
    @GetMapping("/watchlist-profile-params")
    WatchListedProfileDynamicParams listParams() {
        return new WatchListedProfileDynamicParams();
    }

}
