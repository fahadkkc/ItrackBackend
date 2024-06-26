package com.engine.ItrackBackend.controller;

import com.engine.ItrackBackend.model.InwardTransaction;
import com.engine.ItrackBackend.model.dtos.InwardTransactionDto;
import com.engine.ItrackBackend.model.dynamicParams.InwardTransactionsDynamicParams;
import com.engine.ItrackBackend.service.InwardTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inward-transaction")
@RequiredArgsConstructor
public class InwardTransactionController {
    private final InwardTransactionService inwardTransactionService;



    @PutMapping("/{id}")
    InwardTransaction updateInwardTransaction(@RequestParam("id") String id, @RequestBody InwardTransactionDto request) {
        return inwardTransactionService.updateInwardTransaction(id, request);
    }
    @GetMapping("/dynamic-params")
    InwardTransactionsDynamicParams listParams() {
        return new InwardTransactionsDynamicParams();
    }

    @GetMapping("/{accountNo}")
    List<InwardTransaction> listInwardTransactionsByAccountNo(
            @PathVariable("accountNo") Long accountNo) {
        return inwardTransactionService.listInwardTransactionsByAccountNo(accountNo);
    }

//    @GetMapping("/fire-inward-transaction-rule")
//    List<InwardTransaction> fireInwardTransactionRule(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
//        return inwardTransactionService.fireInwardTransactionRule(pageNo, pageLimit);
//    }

//@GetMapping()
//InwardTransaction getInwardTransaction(@RequestParam("id") String id) {
//    return inwardTransactionService.getInwardTransaction(id);
////}
//@GetMapping("/list-inward-transaction")
//List<InwardTransaction> listInwardTransaction(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageLimit") Integer pageLimit) {
//    return inwardTransactionService.listInwardTransaction(pageNo, pageLimit);
//}
}
