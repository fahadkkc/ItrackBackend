package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.model.InwardProfile;
import com.example.ItrackBackend.model.OutwardProfile;
import com.example.ItrackBackend.model.dtos.OutwardProfileDto;
import com.example.ItrackBackend.model.dynamicParams.OutwardProfileDynamicParams;
import com.example.ItrackBackend.service.OutwardProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OutwardProfileController {
    private final OutwardProfileService outwardProfileService;

    @GetMapping("/outward-profile")
    OutwardProfile getOutwardProfile(@RequestParam("id") String id) {
        return outwardProfileService.getOutwardProfile(id);
    }

    @PutMapping("/outward-profile")
    OutwardProfile updateOutwardProfile(@RequestParam("id") String id, @RequestBody OutwardProfileDto request) {
        return outwardProfileService.updateOutwardProfile(id, request);
    }

    @GetMapping("/list-outward-profile")
    List<OutwardProfile> listOutwardProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
        return outwardProfileService.listOutwardProfile(pageNo, pageLimit);

    }

    @GetMapping("/outward-profile-params")
    OutwardProfileDynamicParams listParams() {
        return new OutwardProfileDynamicParams();
    }

    @GetMapping("/list-outward-profile/{accountNo}")
    List<OutwardProfile> listOutwardProfileByAccountNo(
            @RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit,
            @PathVariable("accountNo") Long accountNo) {
        return outwardProfileService.listOutwardProfileByAccountNo(pageNo, pageLimit, accountNo);
    }
}
