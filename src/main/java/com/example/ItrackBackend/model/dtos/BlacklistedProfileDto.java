package com.example.ItrackBackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class BlacklistedProfileDto {
    private String id;

    private Long accountNo;

    private String accountName;

    private String reason;

    private String blacklistDateListedBy;

    private Date blacklistDate;

    private Date modifiedDate;

    private String modifiedUser;
}
