package com.example.springmongojson.model;

import lombok.Data;

@Data
public class Fuel extends Emission{

    private Double quantity;
    private Double carbonContent;
    private Double carbonOxidationRate;
}
