package com.example.springmongojson.controller;

import com.example.springmongojson.model.Carbonate;
import com.example.springmongojson.model.Emission;
import com.example.springmongojson.model.Fuel;
import com.example.springmongojson.repository.EmissionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Case1Controller {

    @Autowired
    private EmissionRepository emissionRepository;

    @SneakyThrows
    @GetMapping("/case1insert")
    public String insert(){
        Fuel f1 = new Fuel();
        f1.setCarbonContent(1.0);
        f1.setQuantity(2.0);
        f1.setCarbonOxidationRate(3.0);
        emissionRepository.insert(f1);

        Carbonate c1 = new Carbonate();
        c1.setFactor(4.0);
        c1.setPurity(5.0);
        c1.setQuantity(6.0);
        emissionRepository.insert(c1);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Emission> emissions = emissionRepository.findAll();
        for(Emission e : emissions){
            System.out.println("class: " + e.getClass());
            String json = objectMapper.writeValueAsString(e);
            System.out.println(json);
        }

        return "ok";
    }
}
