package com.example.springmongojson.controller;

import com.example.springmongojson.model.Carbonate;
import com.example.springmongojson.model.Emission;
import com.example.springmongojson.model.Fuel;
import com.example.springmongojson.model.SiteEmission;
import com.example.springmongojson.repository.EmissionRepository;
import com.example.springmongojson.repository.SiteEmissionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class Case3Controller {

    @Autowired
    private EmissionRepository emissionRepository;

    @Autowired
    private SiteEmissionRepository siteEmissionRepository;

    @SneakyThrows
    @GetMapping("/case3write")
    public SiteEmission write(){
        Fuel f1 = new Fuel();
        f1.setCarbonContent(1.0);
        f1.setQuantity(2.0);
        f1.setCarbonOxidationRate(3.0);

        Carbonate c1 = new Carbonate();
        c1.setFactor(4.0);
        c1.setPurity(5.0);
        c1.setQuantity(6.0);

        SiteEmission siteEmission = new SiteEmission();
        siteEmission.setSiteId("SDAWC1");
        siteEmission.setOrgId("oAFSAFXZEW");
        List<Emission> emissions1 = siteEmission.getEmissions();
        emissions1.add(f1);
        emissions1.add(c1);

        return siteEmission;
    }

    @SneakyThrows
    @PostMapping("/case3read")
    public String read(@RequestBody SiteEmission siteEmission){

        ObjectMapper objectMapper = new ObjectMapper();
        List<SiteEmission> siteEmissions = Collections.singletonList(siteEmission);
        for(SiteEmission e : siteEmissions){
            System.out.println("class: " + e.getClass());
            String json = objectMapper.writeValueAsString(e);
            System.out.println(json);

            List<Emission> emissions = e.getEmissions();
            for(Emission e0 : emissions){
                System.out.println("emission class: " + e0.getClass());
                String js = objectMapper.writeValueAsString(e0);
                System.out.println(js);
            }
        }

        System.out.println("persist to mongodb");
        siteEmissionRepository.save(siteEmission);
        System.out.println("persist to mongodb success");

        siteEmissions = siteEmissionRepository.findAll();
        for(SiteEmission e : siteEmissions){
            System.out.println("class: " + e.getClass());
            String json = objectMapper.writeValueAsString(e);
            System.out.println(json);

            List<Emission> emissions = e.getEmissions();
            for(Emission e0 : emissions){
                System.out.println("emission class: " + e0.getClass());
                String js = objectMapper.writeValueAsString(e0);
                System.out.println(js);
            }
        }


        return "ok";
    }
}
