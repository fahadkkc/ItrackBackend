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
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @PutMapping("/{id}")
    Account updateAccount(@RequestParam("id") String id, @RequestBody AccountDto request) {
        return accountService.updateAccount(id, request);
    }
    @GetMapping("/dynamic-params")
    AccountListingDynamicParams listParams() {
        return new AccountListingDynamicParams();

    }

    @GetMapping("/{accountNo}")
    List<Account> listAccountByAccountNo(
            @PathVariable("accountNo") Long accountNo) {
        return accountService.listAccountByAccountNo( accountNo);
    }





    //NOT NEEDED
//    @GetMapping("/{id}")
//    Account getAccountById(@RequestParam("id") String id) {
//        return accountService.getAccount(id);
//
//    }

//    @GetMapping("/list-account")
//    List<Account> listAccount(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
//        return accountService.listAccount(pageNo, pageLimit);
//
//    }

}
