package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.model.BlacklistedProfile;
import com.example.ItrackBackend.model.dtos.BlacklistedProfileDto;
import com.example.ItrackBackend.service.BlacklistedProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlacklistedProfileController {

    private final BlacklistedProfileService blacklistedProfileService;

    @GetMapping("/blacklist-profile")
    BlacklistedProfile getBlacklistedProfile(@RequestParam("id") String id) {
        return blacklistedProfileService.getBlacklistedProfile(id);

    }

    @PutMapping("/blacklist-profile")
    BlacklistedProfile updateBlacklistedProfile(@RequestParam("id") String id, @RequestBody BlacklistedProfileDto request) {
        return blacklistedProfileService.updateBlacklistedProfile(id, request);
    }

    @GetMapping("/list-blacklist-profile")
    List<BlacklistedProfile> listBlacklistedProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
        return blacklistedProfileService.listBlacklistedProfile(pageNo, pageLimit);

    }
}
