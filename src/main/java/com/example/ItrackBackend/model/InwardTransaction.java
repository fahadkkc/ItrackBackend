package com.example.ItrackBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@AllArgsConstructor
@Data
@Document(collection = "InwardTransactions")
public class InwardTransaction {

    @Id
    private String id;
    @Field(name = "SessionID")
    private String sessionID;
    @Field(name = "AccountNo")
    private Long accountNo;
    @Field(name = "SourceBank")
    private Long sourceBank;
    @Field(name = "DestinationBank")
    private Integer destinationBank;
    @Field(name = "Amount")
    private Long amount;
    @Field(name = "ChannelCode")
    private Integer channelCode;
    @Field(name = "Narration")
    private String narration;
    @Field(name = "TransactionStatus")
    private Integer transactionStatus;
    @Field(name = "DatePosted")
    private String datePosted;
    @Field(name = "OriginatorAccountNumber")
    private Long originatorAccountNumber;
    @Field(name = "OriginatorAccountName")
    private String originatorAccountName;
    @Field(name = "OriginatorBankVerificationNumber")
    private Long originatorBankVerificationNumber;
    @Field(name = "BeneficiaryAccountName")
    private String beneficiaryAccountName;
    @Field(name = "BeneficiaryBankVerificationNumber")
    private String beneficiaryBankVerificationNumber;
    @Field(name = "C24Response")
    private String c24Response;
    @Field(name = "NewStan")
    private Long newStan;
    @Field(name = "RetryColumn")
    private Integer retryColumn;
    @Field(name = "OldStan")
    private Long oldStan;
    @Field(name = "C24Status")
    private Integer c24Status;
    @Field(name = "NibsResStatus")
    private Integer nibsResStatus;
    @Field(name = "DateModified")
    private String dateModified;
}
