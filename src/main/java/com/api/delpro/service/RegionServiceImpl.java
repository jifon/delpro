package com.api.delpro.service;

import com.api.delpro.dao.RegionRepository;
import com.api.delpro.model.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> regionList(){
        return regionRepository.findAll();
    }
    public void createRegion(Region region){
        regionRepository.save(region);
    }
    public void deleteRegion(Long id){
        regionRepository.deleteById(id);
    }
    public Region updatedRegionById(Long id){
        return regionRepository.findById(id).get();
    }

}
