package com.example.ItrackBackend.service;

import com.example.ItrackBackend.model.Account;
import com.example.ItrackBackend.model.InwardTransaction;
import com.example.ItrackBackend.model.dtos.AccountDto;
import com.example.ItrackBackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account getAccount(String id) {
        return accountRepository.findById(id).get();
    }

    public Account updateAccount(String id, AccountDto request) {
        Account account = accountRepository.findById(id).get();
        account.setAccountKey(request.getAccountKey());
        return accountRepository.save(account);
    }

    public List<Account> listAccount(Integer pageNo, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        return accountRepository.findAll(pageable).stream().toList();
    }
    public List<Account> listAccountByAccountNo(Integer pageNo, Integer pageLimit, Long accountNo) {
        Pageable pageable = PageRequest.of(pageNo, pageLimit);
        Page accounts = accountRepository.findByAccountNumber(accountNo, pageable);
        return accounts.stream().toList();
    }
}
