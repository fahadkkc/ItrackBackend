package com.engine.ItrackBackend.service;

import com.engine.ItrackBackend.repository.InwardProfileRepository;
import com.engine.ItrackBackend.model.InwardProfile;
import com.engine.ItrackBackend.model.dtos.InwardProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InwardProfileService {
    private final InwardProfileRepository inwardProfileRepository;

    public InwardProfile getInwardProfile(String id) {
        return inwardProfileRepository.findById(id).get();
    }

    public InwardProfile updateInwardProfile(String id, InwardProfileDto request) {
        InwardProfile inwardProfile = inwardProfileRepository.findById(id).get();
        inwardProfile.setAccountName(request.getAccountName());
        return inwardProfileRepository.save(inwardProfile);
    }

    public List<InwardProfile> listInwardProfile(Integer pageNo, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        return inwardProfileRepository.findAll(pageable).stream().toList();
    }

    public List<InwardProfile> listInwardProfileByAccountNo(Long accountNo) {
        List<InwardProfile> inwardProfiles = inwardProfileRepository.findByAccountNumber(accountNo);
        return inwardProfiles.stream().toList();
    }
}
