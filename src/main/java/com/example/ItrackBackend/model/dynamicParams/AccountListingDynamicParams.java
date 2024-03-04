package com.example.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountListingDynamicParams {
    @Field(name = "AccountNo")
    private Long accountNo;
    private String cumDebit;
    private String cumCredit;
    private String availBal;
}
