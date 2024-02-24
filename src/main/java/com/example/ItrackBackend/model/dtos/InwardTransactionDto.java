package com.example.ItrackBackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InwardTransactionDto {

    private String id;
    private String sessionID;
    private Long accountNo;
    private Long sourceBank;
    private Integer destinationBank;
    private Long amount;
    private Integer channelCode;
    private String narration;
    private Integer transactionStatus;
    private String datePosted;
    private Long originatorAccountNumber;
    private String originatorAccountName;
    private Long originatorBankVerificationNumber;
    private String beneficiaryAccountName;
    private String beneficiaryBankVerificationNumber;
    private String c24Response;
    private Long newStan;
    private Integer retryColumn;
    private Long oldStan;
    private Integer c24Status;
    private Integer nibsResStatus;
    private String dateModified;
}
