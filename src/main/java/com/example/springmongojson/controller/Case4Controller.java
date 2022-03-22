package com.example.springmongojson.controller;

import com.example.springmongojson.model.*;
import com.example.springmongojson.repository.EmissionRepository;
import com.example.springmongojson.repository.SiteEmissionRepository;
import com.example.springmongojson.repository.SiteEmissionV2Repository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class Case4Controller {

    @Autowired
    private EmissionRepository emissionRepository;

    @Autowired
    private SiteEmissionRepository siteEmissionRepository;

    @Autowired
    private SiteEmissionV2Repository siteEmissionV2Repository;


    @SneakyThrows
    @PostMapping("/case4")
    public  List<SiteEmissionV2> read(@RequestBody SiteEmissionV2 siteEmission){

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(siteEmission);

        System.out.println(json);

        System.out.println("persist siteEmission");
        siteEmissionV2Repository.save(siteEmission);
        System.out.println("persist siteEmission over");

        List<SiteEmissionV2> all = siteEmissionV2Repository.findAll();

        String s = objectMapper.writeValueAsString(all);
        System.out.println("emission from mongodb: " + s);

        DocumentContext jsonContext = JsonPath.parse(s);
        Number factor = jsonContext.read("$.[0].emissions[1].factor");
        System.out.println("json path of factor: " + factor);

        return all;
    }
}
