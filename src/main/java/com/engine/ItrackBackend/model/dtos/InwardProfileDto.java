package com.engine.ItrackBackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InwardProfileDto {

    private String id;
    private Long accountNo;
    private String accountName;
    private String minAmt;
    private String avgAmt;
    private String maxAmt;
    private String createdBy;
    private String profileDate;
    private String modifiedBy;
    private String dateModified;
}
