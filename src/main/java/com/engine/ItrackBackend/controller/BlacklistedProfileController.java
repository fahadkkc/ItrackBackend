package com.engine.ItrackBackend.controller;

import com.engine.ItrackBackend.model.BlacklistedProfile;
import com.engine.ItrackBackend.model.dtos.BlacklistedProfileDto;
import com.engine.ItrackBackend.model.dynamicParams.BlackListedProfileDynamicParams;
import com.engine.ItrackBackend.service.BlacklistedProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blacklist-profile")
@RequiredArgsConstructor
public class BlacklistedProfileController {

    private final BlacklistedProfileService blacklistedProfileService;


    @PutMapping("/")
    BlacklistedProfile updateBlacklistedProfile(@RequestParam("id") String id, @RequestBody BlacklistedProfileDto request) {
        return blacklistedProfileService.updateBlacklistedProfile(id, request);
    }
    @GetMapping("/dynamic-params")
    BlackListedProfileDynamicParams listParams() {
        return new BlackListedProfileDynamicParams();
    }

    @GetMapping("/{accountNo}")
    List<BlacklistedProfile> listBlacklistProfileByAccountNo(
            @PathVariable("accountNo") Long accountNo) {
        return blacklistedProfileService.listBlacklistProfileByAccountNo(accountNo);
    }

//    @GetMapping("/")
//    BlacklistedProfile getBlacklistedProfile(@RequestParam("id") String id) {
//        return blacklistedProfileService.getBlacklistedProfile(id);
//
//    }
//    @GetMapping("/list-blacklist-profile")
//    List<BlacklistedProfile> listBlacklistedProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
//        return blacklistedProfileService.listBlacklistedProfile(pageNo, pageLimit);
//
//    }

}
