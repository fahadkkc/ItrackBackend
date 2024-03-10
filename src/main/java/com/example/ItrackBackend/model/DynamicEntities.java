package com.example.ItrackBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "dynamic_rule_entity")
public class DynamicEntities {
    public String entityName;
    public String collectionName;
}
