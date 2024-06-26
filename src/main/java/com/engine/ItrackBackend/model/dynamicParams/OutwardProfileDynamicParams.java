package com.engine.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@Data
@Builder
public class OutwardProfileDynamicParams {

    private Long accountNo;
    private String minAmount;
    private String avgAmount;
    private Long maxAmount;
    private Date profileDate;

    public OutwardProfileDynamicParams() {
        this.accountNo = 0L;
        this.minAmount = "0";
        this.avgAmount = "0";
        this.maxAmount = 0L;
        this.profileDate = new Date(); // You may use a specific default date if needed
    }
}
