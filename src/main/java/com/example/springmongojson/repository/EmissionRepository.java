package com.example.springmongojson.repository;

import com.example.springmongojson.model.Emission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmissionRepository extends MongoRepository<Emission, String> {

}
