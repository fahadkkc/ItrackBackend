package com.engine.ItrackBackend.service;

import com.engine.ItrackBackend.repository.InwardTransactionRepository;
import com.engine.ItrackBackend.model.FlagFact;
import com.engine.ItrackBackend.model.InwardTransaction;
import com.engine.ItrackBackend.model.dtos.InwardTransactionDto;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
        FlagFact flagFact = new FlagFact(true); // Initialize the flag as true
        kieSession.insert(flagFact); // Insert the FlagFact instance into the session

        List<InwardTransaction> inwardTransactionList = inwardTransactionRepository.findAll(pageable).stream().toList();
        for (InwardTransaction inwardTransaction : inwardTransactionList) {
            kieSession.insert(inwardTransaction);
            kieSession.fireAllRules();
            boolean flag = flagFact.isFlag();
        }

        return inwardTransactionList;
    }

    public List<InwardTransaction> listInwardTransactionsByAccountNo(Long accountNo) {
        List<InwardTransaction> inwardTransactions = inwardTransactionRepository.findByAccountNumber(accountNo);
        return inwardTransactions.stream().toList();
    }
}
