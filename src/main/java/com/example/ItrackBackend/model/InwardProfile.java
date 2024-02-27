package com.example.ItrackBackend.model;

import com.example.ItrackBackend.model.dynamicParams.InwardProfileDynamicParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "inward_profile")
public class InwardProfile {

    @Id
    private String id;
    @Field(name = "accountname")
    private String accountName;
    @Field(name = "createdby")
    private String createdBy;
    @Field(name = "modifiedby")
    private String modifiedBy;
    @Field(name = "date_modified")
    private String dateModified;
    private InwardProfileDynamicParams dynamicParams;
}
