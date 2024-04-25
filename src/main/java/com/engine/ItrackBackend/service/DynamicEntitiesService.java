package com.engine.ItrackBackend.service;

import com.engine.ItrackBackend.model.DynamicEntities;
import com.engine.ItrackBackend.repository.DynamicEntitiesRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DynamicEntitiesService {
    @Autowired
    private final DynamicEntitiesRepository dynamicEntitiesRepository;

    public List<DynamicEntities> getDynamicEntities(){
        return dynamicEntitiesRepository.findAll();
    }
}
