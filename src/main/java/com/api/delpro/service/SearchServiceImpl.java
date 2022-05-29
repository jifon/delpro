package com.api.delpro.service;

import com.api.delpro.model.Delivery;
import com.api.delpro.model.dto.DeliveryDTO;
import com.api.delpro.model.dto.SearchDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class SearchServiceImpl {
    private final DeliveryService deliveryService;

    public SearchServiceImpl(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    // Выдает вырианты перевозок


    public List<DeliveryDTO> search(SearchDTO searchDTO){
        List<Delivery> deliveryList = deliveryService.findAllDeliveries();
        List<DeliveryDTO> deliveryDTOS = new ArrayList<>();
        for(Delivery delivery : deliveryList){
            double price = delivery.getPrice().getVolumetric_weight_price();
            double length = searchDTO.getLength();
            double width = searchDTO.getWidth();
            double height = searchDTO.getHeight();
            int km = searchDTO.getKm();
            double volumetricWeight = (length*width*height)/5000;
            double totalCost = volumetricWeight*price*km;
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String  result = decimalFormat.format(totalCost);
            DeliveryDTO dto = new DeliveryDTO();
            dto.setName(delivery.getName());
            dto.setTotalCost(result);
            deliveryDTOS.add(dto);
        }
        return deliveryDTOS;
    }

}
