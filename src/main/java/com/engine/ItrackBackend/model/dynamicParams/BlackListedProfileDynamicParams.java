package com.engine.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class BlackListedProfileDynamicParams {
    private Long accountNo;
    private String reason;
    private Date blackListedDate;
    public BlackListedProfileDynamicParams() {
        this.accountNo = 0L;
        this.reason = "";
        this.blackListedDate = new Date(); // You may use a specific default date if needed
    }
}
