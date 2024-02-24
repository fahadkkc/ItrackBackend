package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.model.InwardProfile;
import com.example.ItrackBackend.model.dtos.InwardProfileDto;
import com.example.ItrackBackend.service.InwardProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InwardProfileController {
    private final InwardProfileService inwardProfileService;

    @GetMapping("/inward-profile")
    InwardProfile getInwardProfile(@RequestParam("id") String id) {
        return inwardProfileService.getInwardProfile(id);
    }

    @PutMapping("/inward-profile")
    InwardProfile updateInwardProfile(@RequestParam("id") String id, @RequestBody InwardProfileDto request) {
        return inwardProfileService.updateInwardProfile(id, request);
    }

    @GetMapping("/list-inward-profile")
    List<InwardProfile> listInwardProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
        return inwardProfileService.listInwardProfile(pageNo, pageLimit);

    }
}
