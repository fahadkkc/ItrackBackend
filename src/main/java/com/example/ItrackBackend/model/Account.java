package com.example.ItrackBackend.model;

import com.example.ItrackBackend.model.dynamicParams.AccountListingDynamicParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "account_listing")
public class Account {

    @Id
    private String id;
    @Field(name = "accountname")
    private String accountName;
    @Field(name = "dom_branch")
    private String domBranch;
    @Field(name = "account_gl")
    private String accountGl;
    @Field(name = "account_type")
    private String accountType;
    @Field(name = "date_open")
    private Date dateOpen;
    private String status;
    private Date statusDate;
    @Field(name = "clr_bal")
    private String clrBal;
    @Field(name = "cum_debit")
    private String cumDebit;
    @Field(name = "avail_bal")
    private String availBal;
    @Field(name = "last_tran_date")
    private String lastTransactionDate;
    @Field(name = "accountkey")
    private String accountKey;
    @Field(name = "cust_key")
    private String customerKey;
    private String accountMgr;
    @Field(name = "acct_currency")
    private String acctCurrency;
    private AccountListingDynamicParams dynamicParams;
}
