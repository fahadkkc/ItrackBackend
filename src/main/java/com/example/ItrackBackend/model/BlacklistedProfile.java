package com.example.ItrackBackend.model;

import com.example.ItrackBackend.model.dynamicParams.BlackListedProfileDynamicParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "black_listed_profile")
public class BlacklistedProfile {
    @Id
    private String id;
    @Field(name = "accountname")
    private String accountName;
    @Field(name = "blacklistdatelistedby")
    private String blacklistDateListedBy;
    @Field(name = "modifiedDate")
    private Date modifiedDate;
    @Field(name = "modifieduser")
    private String modifiedUser;
    private BlackListedProfileDynamicParams dynamicParams;
}
