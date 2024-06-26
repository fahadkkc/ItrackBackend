package com.engine.ItrackBackend.controller;

import com.engine.ItrackBackend.model.OutwardProfile;
import com.engine.ItrackBackend.model.dtos.OutwardProfileDto;
import com.engine.ItrackBackend.model.dynamicParams.OutwardProfileDynamicParams;
import com.engine.ItrackBackend.service.OutwardProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outward-profile")
@RequiredArgsConstructor
public class OutwardProfileController {
    private final OutwardProfileService outwardProfileService;

    @PutMapping("/{id}")
    OutwardProfile updateOutwardProfile(@RequestParam("id") String id, @RequestBody OutwardProfileDto request) {
        return outwardProfileService.updateOutwardProfile(id, request);
    }

    @GetMapping("/dynamic-params")
    OutwardProfileDynamicParams listParams() {
        return new OutwardProfileDynamicParams();
    }

    @GetMapping("/{accountNo}")
    List<OutwardProfile> listOutwardProfileByAccountNo(
            @PathVariable("accountNo") Long accountNo) {
        return outwardProfileService.listOutwardProfileByAccountNo(accountNo);
    }
//
//    @GetMapping("/list-outward-profile")
//    List<OutwardProfile> listOutwardProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
//        return outwardProfileService.listOutwardProfile(pageNo, pageLimit);
//
////    }
//@GetMapping()
//OutwardProfile getOutwardProfile(@RequestParam("id") String id) {
//    return outwardProfileService.getOutwardProfile(id);
}

