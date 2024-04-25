package com.engine.ItrackBackend.service;

import com.engine.ItrackBackend.repository.OutwardProfileRepository;
import com.engine.ItrackBackend.model.OutwardProfile;
import com.engine.ItrackBackend.model.dtos.OutwardProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutwardProfileService {
    private final OutwardProfileRepository outwardProfileRepository;

    public OutwardProfile getOutwardProfile(String id) {
        return outwardProfileRepository.findById(id).get();
    }

    public OutwardProfile updateOutwardProfile(String id, OutwardProfileDto request) {
        OutwardProfile outwardProfile = outwardProfileRepository.findById(id).get();
        outwardProfile.setAccountName(request.getAccountName());
        return outwardProfileRepository.save(outwardProfile);
    }

    public List<OutwardProfile> listOutwardProfile(Integer pageNo, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        return outwardProfileRepository.findAll(pageable).stream().toList();
    }

    public List<OutwardProfile> listOutwardProfileByAccountNo(Long accountNo) {
        List<OutwardProfile> outwardProfileRepositoryByAccountNumber = outwardProfileRepository.findByAccountNumber(accountNo);
        return outwardProfileRepositoryByAccountNumber.stream().toList();
    }
}
