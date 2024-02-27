package com.example.ItrackBackend.model;

import com.example.ItrackBackend.model.dynamicParams.WatchListedProfileDynamicParams;
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
@Document(collection = "watch_listed_profile")
public class WatchlistProfile {

    @Id
    private String id;
    @Field(name = "accountname")
    private String accountName;
    @Field(name = "watchlistedby")
    private String watchListedBy;
    @Field(name = "modifiedDate")
    private Date modifiedDate;
    @Field(name = "modifieduser")
    private String modifiedUser;
    private WatchListedProfileDynamicParams dynamicParams;
}
