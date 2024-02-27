package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.model.Account;
import com.example.ItrackBackend.model.dtos.AccountDto;
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
    Account listParams() {
        return new Account();
    }
}
