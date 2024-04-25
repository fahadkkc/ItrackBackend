package com.engine.ItrackBackend.model;

import com.engine.ItrackBackend.model.dynamicParams.OutwardProfileDynamicParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "outward_profile")
public class OutwardProfile {

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
    private OutwardProfileDynamicParams dynamicParams;
}
