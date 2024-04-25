package com.engine.ItrackBackend.service;

import com.engine.ItrackBackend.repository.BlacklistedProfileRepository;
import com.engine.ItrackBackend.model.BlacklistedProfile;
import com.engine.ItrackBackend.model.dtos.BlacklistedProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlacklistedProfileService {

    private final BlacklistedProfileRepository blacklistedProfileRepository;

    public BlacklistedProfile getBlacklistedProfile(String id) {
        return blacklistedProfileRepository.findById(id).get();
    }

    public BlacklistedProfile updateBlacklistedProfile(String id, BlacklistedProfileDto request) {
        BlacklistedProfile account = blacklistedProfileRepository.findById(id).get();
        account.setAccountName(request.getAccountName());
        return blacklistedProfileRepository.save(account);
    }

    public List<BlacklistedProfile> listBlacklistedProfile(Integer pageNo, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        return blacklistedProfileRepository.findAll(pageable).stream().toList();
    }

    public List<BlacklistedProfile> listBlacklistProfileByAccountNo(Long accountNo) {
        List<BlacklistedProfile> blacklistedProfileRepositoryByAccountNumber = blacklistedProfileRepository.findByAccountNumber(accountNo);
        return blacklistedProfileRepositoryByAccountNumber.stream().toList();
    }
}
