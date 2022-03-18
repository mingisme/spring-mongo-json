package com.example.springmongojson.model;

import lombok.Data;

@Data
public class Carbonate extends Emission{
    private Double quantity;
    private Double purity;
    private Double factor;
}
