package com.example.ItrackBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Data
@Document(collection="BlacklistedProfile")
public class BlacklistedProfile {
    @Id
    private String id;
    @Field(name="accountno")
    private Long accountNo;
    @Field(name="accountname")
    private String accountName;
    @Field(name="reason")
    private String reason;
    @Field(name="blacklistdatelistedby")
    private String blacklistDateListedBy;
    @Field(name="blacklistdate")
    private String blacklistDate;
    @Field(name="modifiedDate")
    private String modifiedDate;
    @Field(name="modifieduser")
    private String modifiedUser;
}
