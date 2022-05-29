package com.api.delpro.service;

import com.api.delpro.dao.CityRepository;
import com.api.delpro.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    private final CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    public List<City> cityList(){
        return cityRepository.findAll();
    }
    public void createCity(City city){
        cityRepository.save(city);
    }
    public void deleteCity(Long id){
        cityRepository.deleteById(id);
    }
    public City updatedCityById(Long id){
        return cityRepository.findById(id).get();
    }
}
