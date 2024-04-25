package com.engine.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Data
@Builder
public class AccountListingDynamicParams {
    @Field(name = "AccountNo")
    private Long accountNo;
    private String cumDebit;
    private String cumCredit;
    private String availBal;

    public AccountListingDynamicParams() {
        this.accountNo = 0L;
        this.cumDebit = "0";
        this.cumCredit = "0";
        this.availBal = "";
    }
}
