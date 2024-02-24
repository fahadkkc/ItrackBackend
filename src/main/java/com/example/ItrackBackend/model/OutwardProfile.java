package com.example.ItrackBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@AllArgsConstructor
@Data
@Document(collection = "OutwardProfile")
public class OutwardProfile {

    @Id
    private String id;
    @Field(name = "accountno")
    private Long accountNo;
    @Field(name = "accountname")
    private String accountName;
    @Field(name = "min_amt")
    private String minAmt;
    @Field(name = "avg_amt")
    private String avgAmt;
    @Field(name = "max_amt")
    private String maxAmt;
    @Field(name = "createdby")
    private String createdBy;
    @Field(name = "profile_date")
    private String profileDate;
    @Field(name = "modifiedby")
    private String modifiedBy;
    @Field(name = "date_modified")
    private String dateModified;
}
