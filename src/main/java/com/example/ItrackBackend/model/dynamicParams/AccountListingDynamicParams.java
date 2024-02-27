package com.example.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountListingDynamicParams {
    private Long AccountNo;
    private String cumDebit;
    private String cumCredit;
    private String availBal;
}
