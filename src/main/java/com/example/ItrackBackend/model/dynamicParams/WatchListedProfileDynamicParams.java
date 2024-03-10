package com.example.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class WatchListedProfileDynamicParams {
    private Long accountNo;
    private String reason;
    private Date watchlistDate;

    public WatchListedProfileDynamicParams() {
        this.accountNo = 0L;
        this.reason = "";
        this.watchlistDate = new Date(); // You may use a specific default date if needed
    }
}
