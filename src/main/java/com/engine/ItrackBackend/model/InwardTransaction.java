package com.engine.ItrackBackend.model;

import com.engine.ItrackBackend.model.dynamicParams.InwardTransactionsDynamicParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "test_inward_transactions")
public class InwardTransaction {

    @Id
    private String id;
    @Field(name = "SessionID")
    private String sessionID;
    @Field(name = "DestinationBank")
    private Long destinationBank;
    @Field(name = "ChannelCode")
    private Integer channelCode;
    @Field(name = "Narration")
    private String narration;
    @Field(name = "DatePosted")
    private Date datePosted;
    @Field(name = "OriginatorAccountNumber")
    private Long originatorAccountNumber;
    @Field(name = "OriginatorAccountName")
    private String originatorAccountName;
    @Field(name = "OriginatorBankVerificationNumber")
    private Long originatorBankVerificationNumber;
    @Field(name = "BeneficiaryAccountName")
    private String beneficiaryAccountName;
    @Field(name = "BeneficiaryBankVerificationNumber")
    private Long beneficiaryBankVerificationNumber;
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
    @Field(name = "Amount")
    private Long amount;
    private InwardTransactionsDynamicParams dynamicParams;
}
