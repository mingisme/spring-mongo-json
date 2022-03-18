package com.example.springmongojson.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Fuel.class, name = "com.example.springmongojson.model.Fuel"),
        @JsonSubTypes.Type(value = Carbonate.class, name= "com.example.springmongojson.model.Carbonate")
})
@Document("emission")
public abstract class Emission {

    @Id
    private String id;



}
