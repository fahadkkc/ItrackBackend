package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.model.InwardTransaction;
import com.example.ItrackBackend.model.dtos.InwardTransactionDto;
import com.example.ItrackBackend.service.InwardTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InwardTransactionController {
    private final InwardTransactionService inwardTransactionService;

    @GetMapping("/inward-transaction")
    InwardTransaction getInwardTransaction(@RequestParam("id") String id) {
        return inwardTransactionService.getInwardTransaction(id);
    }

    @PutMapping("/inward-transaction")
    InwardTransaction updateInwardTransaction(@RequestParam("id") String id, @RequestBody InwardTransactionDto request) {
        return inwardTransactionService.updateInwardTransaction(id, request);
    }

    @GetMapping("/list-inward-transaction")
    List<InwardTransaction> listInwardTransaction(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
        return inwardTransactionService.listInwardTransaction(pageNo, pageLimit);
    }

    @GetMapping("/fire-inward-transaction-rule")
    List<InwardTransaction> fireInwardTransactionRule(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
        return inwardTransactionService.fireInwardTransactionRule(pageNo,pageLimit);
    }
}
