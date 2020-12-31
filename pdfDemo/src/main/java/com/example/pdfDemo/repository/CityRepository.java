package com.example.pdfDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.pdfDemo.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
