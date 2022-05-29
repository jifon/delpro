package com.api.delpro.service;

import com.api.delpro.model.Region;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RegionService {
    List<Region> regionList();
    void createRegion(Region region);
    void deleteRegion(Long id);
    Region updatedRegionById(Long id);
}
