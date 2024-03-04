package com.example.ItrackBackend.service;

import com.example.ItrackBackend.model.Account;
import com.example.ItrackBackend.model.BlacklistedProfile;
import com.example.ItrackBackend.model.dtos.BlacklistedProfileDto;
import com.example.ItrackBackend.repository.BlacklistedProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    public List<BlacklistedProfile> listBlacklistProfileByAccountNo(Integer pageNo, Integer pageLimit, Long accountNo) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        Page blacklistedProfileRepositoryByAccountNumber = blacklistedProfileRepository.findByAccountNumber(accountNo, pageable);
        return blacklistedProfileRepositoryByAccountNumber.stream().toList();
    }
}
