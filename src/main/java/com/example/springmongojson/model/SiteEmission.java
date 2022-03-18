package com.example.springmongojson.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("site_emission")
public class SiteEmission {

    private String siteId;
    private String orgId;
    private List<Emission> emissions = new ArrayList<>();


}
