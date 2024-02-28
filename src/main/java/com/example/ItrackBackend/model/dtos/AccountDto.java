package com.example.ItrackBackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AccountDto {
    private String id;
    private Long accountNo;
    private String accountName;
    private String domBranch;
    private String accountGl;
    private String accountType;
    private String dateOpen;
    private String status;
    private String statusDate;
    private String clrBal;
    private String cumDebit;
    private String cumCredit;
    private String availBal;
    private String lastTransactionDate;
    private String accountKey;
    private String customerKey;
    private String accountMgr;
    private String acctCurrency;
}

