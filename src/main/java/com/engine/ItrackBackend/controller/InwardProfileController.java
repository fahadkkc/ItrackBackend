package com.engine.ItrackBackend.controller;

import com.engine.ItrackBackend.model.InwardProfile;
import com.engine.ItrackBackend.model.dtos.InwardProfileDto;
import com.engine.ItrackBackend.model.dynamicParams.InwardProfileDynamicParams;
import com.engine.ItrackBackend.service.InwardProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inward-profile")
@RequiredArgsConstructor
public class InwardProfileController {
    private final InwardProfileService inwardProfileService;


    @PutMapping("/{id}")
    InwardProfile updateInwardProfile(@RequestParam("id") String id, @RequestBody InwardProfileDto request) {
        return inwardProfileService.updateInwardProfile(id, request);
    }


    @GetMapping("/dynamic-params")
    InwardProfileDynamicParams listParams() {
        return new InwardProfileDynamicParams();
    }

    @GetMapping("/{accountNo}")
    List<InwardProfile> listInwardProfileByAccountNo(

            @PathVariable("accountNo") Long accountNo) {
        return inwardProfileService.listInwardProfileByAccountNo( accountNo);
    }



//    @GetMapping("/inward-profile")
//    InwardProfile getInwardProfile(@RequestParam("id") String id) {
//        return inwardProfileService.getInwardProfile(id);
//    }
//
//    @GetMapping("/list-inward-profile")
//    List<InwardProfile> listInwardProfile(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
//        return inwardProfileService.listInwardProfile(pageNo, pageLimit);
//
//    }
}
