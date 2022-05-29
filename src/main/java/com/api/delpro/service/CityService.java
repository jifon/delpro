package com.api.delpro.service;

import com.api.delpro.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<City> cityList();
    void createCity(City city);
    void deleteCity(Long id);
    City updatedCityById(Long id);
}
