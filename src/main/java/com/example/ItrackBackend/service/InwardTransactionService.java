package com.example.ItrackBackend.service;

import com.example.ItrackBackend.model.InwardTransaction;
import com.example.ItrackBackend.model.dtos.InwardTransactionDto;
import com.example.ItrackBackend.repository.InwardTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InwardTransactionService {
    private final InwardTransactionRepository inwardTransactionRepository;
    private final KieSession kieSession;

    public InwardTransaction getInwardTransaction(String id) {
        return inwardTransactionRepository.findById(id).get();
    }

    public InwardTransaction updateInwardTransaction(String id, InwardTransactionDto request) {
        InwardTransaction inwardTransaction = inwardTransactionRepository.findById(id).get();
        inwardTransaction.setBeneficiaryAccountName(request.getBeneficiaryAccountName());
        return inwardTransactionRepository.save(inwardTransaction);
    }

    public List<InwardTransaction> listInwardTransaction(Integer pageNo, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        return inwardTransactionRepository.findAll(pageable).stream().toList();
    }

    public List<InwardTransaction> fireInwardTransactionRule(Integer pageNo, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        List<InwardTransaction> inwardTransactionList = inwardTransactionRepository.findAll(pageable).stream().toList();
        for (InwardTransaction inwardTransaction : inwardTransactionList) {
            kieSession.insert(inwardTransaction);
            kieSession.fireAllRules();
        }
        return inwardTransactionList;
    }

    public List<InwardTransaction> listInwardTransactionsByAccountNo(Integer pageNo, Integer pageLimit, Long accountNo) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        Page inwardTransactions = inwardTransactionRepository.findByAccountNumber(accountNo, pageable);
        return inwardTransactions.stream().toList();
    }
}
