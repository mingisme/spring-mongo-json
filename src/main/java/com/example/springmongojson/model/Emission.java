package com.example.springmongojson.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("emission")
public abstract class Emission {

    @Id
    private String id;



}
