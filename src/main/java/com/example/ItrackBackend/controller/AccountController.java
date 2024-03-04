package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.model.Account;
import com.example.ItrackBackend.model.InwardTransaction;
import com.example.ItrackBackend.model.dtos.AccountDto;
import com.example.ItrackBackend.model.dynamicParams.AccountListingDynamicParams;
import com.example.ItrackBackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/account")
    Account getAccount(@RequestParam("id") String id) {
        return accountService.getAccount(id);

    }

    @PutMapping("/account")
    Account getAccount(@RequestParam("id") String id, @RequestBody AccountDto request) {
        return accountService.updateAccount(id, request);
    }

    @GetMapping("/list-account")
    List<Account> listAccount(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
        return accountService.listAccount(pageNo, pageLimit);

    }

    @GetMapping("/account-params")
    AccountListingDynamicParams listParams() {
        return new AccountListingDynamicParams();
    }

    @GetMapping("/list-account/{accountNo}")
    List<Account> listAccountByAccountNo(
            @RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit,
            @PathVariable("accountNo") Long accountNo) {
        return accountService.listAccountByAccountNo(pageNo, pageLimit, accountNo);
    }
}
