package com.example.ItrackBackend.service;

import com.example.ItrackBackend.model.DynamicEntities;

import com.example.ItrackBackend.repository.DynamicEntitiesRepository;
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
