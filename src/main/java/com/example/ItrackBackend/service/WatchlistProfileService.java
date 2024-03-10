package com.example.ItrackBackend.service;

import com.example.ItrackBackend.model.OutwardProfile;
import com.example.ItrackBackend.model.WatchlistProfile;
import com.example.ItrackBackend.model.dtos.WatchlistProfileDto;
import com.example.ItrackBackend.repository.WatchlistProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchlistProfileService {
    private final WatchlistProfileRepository watchlistProfileRepository;

    public WatchlistProfile getWatchlistProfile(String id) {
        return watchlistProfileRepository.findById(id).get();
    }

    public WatchlistProfile updateWatchlistProfile(String id, WatchlistProfileDto request) {
        WatchlistProfile watchlistProfile = watchlistProfileRepository.findById(id).get();
        watchlistProfile.setAccountName(request.getAccountName());
        return watchlistProfileRepository.save(watchlistProfile);
    }

    public List<WatchlistProfile> listWatchlistProfile(Integer pageNo, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        return watchlistProfileRepository.findAll(pageable).stream().toList();
    }

    public List<WatchlistProfile> listWatchlistProfileByAccountNo(Long accountNo) {

        List<WatchlistProfile> watchlistProfileRepositoryByAccountNumber = watchlistProfileRepository.findByAccountNumber(accountNo);
        return watchlistProfileRepositoryByAccountNumber.stream().toList();
    }
}
