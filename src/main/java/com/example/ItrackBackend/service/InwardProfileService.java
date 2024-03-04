package com.example.ItrackBackend.service;

import com.example.ItrackBackend.model.BlacklistedProfile;
import com.example.ItrackBackend.model.InwardProfile;
import com.example.ItrackBackend.model.dtos.BlacklistedProfileDto;
import com.example.ItrackBackend.model.dtos.InwardProfileDto;
import com.example.ItrackBackend.repository.InwardProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    public List<InwardProfile> listInwardProfileByAccountNo(Integer pageNo, Integer pageLimit, Long accountNo) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        Page inwardProfiles = inwardProfileRepository.findByAccountNumber(accountNo, pageable);
        return inwardProfiles.stream().toList();
    }
}
