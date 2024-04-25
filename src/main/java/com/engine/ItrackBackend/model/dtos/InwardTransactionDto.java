package com.engine.ItrackBackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Getter
@Setter
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Long getSourceBank() {
        return sourceBank;
    }

    public void setSourceBank(Long sourceBank) {
        this.sourceBank = sourceBank;
    }

    public Integer getDestinationBank() {
        return destinationBank;
    }

    public void setDestinationBank(Integer destinationBank) {
        this.destinationBank = destinationBank;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(Integer channelCode) {
        this.channelCode = channelCode;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public Long getOriginatorAccountNumber() {
        return originatorAccountNumber;
    }

    public void setOriginatorAccountNumber(Long originatorAccountNumber) {
        this.originatorAccountNumber = originatorAccountNumber;
    }

    public String getOriginatorAccountName() {
        return originatorAccountName;
    }

    public void setOriginatorAccountName(String originatorAccountName) {
        this.originatorAccountName = originatorAccountName;
    }

    public Long getOriginatorBankVerificationNumber() {
        return originatorBankVerificationNumber;
    }

    public void setOriginatorBankVerificationNumber(Long originatorBankVerificationNumber) {
        this.originatorBankVerificationNumber = originatorBankVerificationNumber;
    }

    public String getBeneficiaryAccountName() {
        return beneficiaryAccountName;
    }

    public void setBeneficiaryAccountName(String beneficiaryAccountName) {
        this.beneficiaryAccountName = beneficiaryAccountName;
    }

    public String getBeneficiaryBankVerificationNumber() {
        return beneficiaryBankVerificationNumber;
    }

    public void setBeneficiaryBankVerificationNumber(String beneficiaryBankVerificationNumber) {
        this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
    }

    public String getC24Response() {
        return c24Response;
    }

    public void setC24Response(String c24Response) {
        this.c24Response = c24Response;
    }

    public Long getNewStan() {
        return newStan;
    }

    public void setNewStan(Long newStan) {
        this.newStan = newStan;
    }

    public Integer getRetryColumn() {
        return retryColumn;
    }

    public void setRetryColumn(Integer retryColumn) {
        this.retryColumn = retryColumn;
    }

    public Long getOldStan() {
        return oldStan;
    }

    public void setOldStan(Long oldStan) {
        this.oldStan = oldStan;
    }

    public Integer getC24Status() {
        return c24Status;
    }

    public void setC24Status(Integer c24Status) {
        this.c24Status = c24Status;
    }

    public Integer getNibsResStatus() {
        return nibsResStatus;
    }

    public void setNibsResStatus(Integer nibsResStatus) {
        this.nibsResStatus = nibsResStatus;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
