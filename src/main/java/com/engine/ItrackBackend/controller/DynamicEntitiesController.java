package com.engine.ItrackBackend.controller;

import com.engine.ItrackBackend.model.DynamicEntities;
import com.engine.ItrackBackend.service.DynamicEntitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dynamic-entities")
@RequiredArgsConstructor
public class DynamicEntitiesController {
    @Autowired
    private final DynamicEntitiesService dynamicEntitiesService;

    @GetMapping()
    public List<DynamicEntities> getDynamicEntities(){
        return dynamicEntitiesService.getDynamicEntities();
    }
}
