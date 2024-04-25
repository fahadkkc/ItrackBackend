package com.engine.ItrackBackend.controller;

import com.engine.ItrackBackend.model.WatchlistProfile;
import com.engine.ItrackBackend.model.dtos.WatchlistProfileDto;
import com.engine.ItrackBackend.model.dynamicParams.WatchListedProfileDynamicParams;
import com.engine.ItrackBackend.service.WatchlistProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist-profile")
@RequiredArgsConstructor
public class WatchlistProfileController {
    private final WatchlistProfileService watchlistProfileService;

    @PutMapping("/{id}")
    WatchlistProfile updateWatchlistProfile(@RequestParam("id") String id, @RequestBody WatchlistProfileDto request) {
        return watchlistProfileService.updateWatchlistProfile(id, request);
    }
    @GetMapping("/dynamic-params")
    WatchListedProfileDynamicParams listParams() {
        return new WatchListedProfileDynamicParams();
    }

    @GetMapping("/{accountNo}")
    List<WatchlistProfile> listWatchlistProfileByAccountNo(
            @PathVariable("accountNo") Long accountNo) {
        return watchlistProfileService.listWatchlistProfileByAccountNo(accountNo);
    }

//    @GetMapping("/")
//    WatchlistProfile getWatchlistProfile(@RequestParam("id") String id) {
//        return watchlistProfileService.getWatchlistProfile(id);
//
//    }
//    @GetMapping("/list-watchlist-profile")
//    List<WatchlistProfile> listWatchlistProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
//        return watchlistProfileService.listWatchlistProfile(pageNo, pageLimit);
//
//    }

}
