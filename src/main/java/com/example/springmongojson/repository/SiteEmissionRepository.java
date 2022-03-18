package com.example.springmongojson.repository;

import com.example.springmongojson.model.SiteEmission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteEmissionRepository extends MongoRepository<SiteEmission, String> {

}
