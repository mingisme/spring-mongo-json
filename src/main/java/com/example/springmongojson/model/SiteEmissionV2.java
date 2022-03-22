package com.example.springmongojson.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("site_emission_v2")
public class SiteEmissionV2 {

    @Id
    private Long id = System.currentTimeMillis();

    private String siteId;
    private String orgId;
    private List<Object> emissions = new ArrayList<>();


}
