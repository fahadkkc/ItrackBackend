package com.example.ItrackBackend.model.dynamicParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OutwardProfileDynamicParams {

    private Long accountNo;
    private String minAmount;
    private String avgAmount;
    private Long maxAmount;
    private Date profileDate;
}
