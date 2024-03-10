package com.example.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Data
@Builder
public class InwardTransactionsDynamicParams {
    @Field(name = "AccountNo")
    private Long accountNo;
    @Field(name = "SourceBank")
    private Long sourceBank;
    @Field(name = "TransactionStatus")
    private Integer transactionStatus;
    @Field(name = "Amount")
    private Long amount;

    public InwardTransactionsDynamicParams() {
        this.accountNo = 0L;
        this.sourceBank = 0L;
        this.transactionStatus = 0; // You may use another default value
        this.amount = 0L;
    }


}
