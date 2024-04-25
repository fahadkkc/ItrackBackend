package com.engine.ItrackBackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OutwardProfileDto {

    private String id;
    private Long accountNo;
    private String accountName;
    private Long minAmt;
    private Long avgAmt;
    private Long maxAmt;
    private String createdBy;
    private String profileDate;
    private String modifiedBy;
    private String dateModified;
}
