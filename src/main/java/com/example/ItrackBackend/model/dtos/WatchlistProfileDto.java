package com.example.ItrackBackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WatchlistProfileDto {

    private String id;

    private Long accountNo;

    private String accountName;

    private String reason;

    private String watchlistBy;

    private String watchlistDate;

    private String modifiedDate;

    private String modifiedUser;
}
