package com.api.delpro.controller;


import com.api.delpro.model.Address;
import com.api.delpro.model.Delivery;
import com.api.delpro.service.AddressServiceImpl;
import com.api.delpro.service.DeliveryServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryServiceImpl service;

    @GetMapping("/all")
    public List<Delivery> listAllDeliveries() {
        return service.findAllDeliveries();
    }

    @GetMapping(value = "/{deliveryId}")
    public Optional<Delivery> getDelivery(@PathVariable("deliveryId") Long deliveryId) throws EntityNotFoundException, ChangeSetPersister.NotFoundException {
        return service.findById(deliveryId);
    }

    @PostMapping
    public void createDelivery(@RequestBody Delivery delivery) {
        service.save(delivery);
    }

    @PutMapping(value = "/{deliveryId}")
    public void updateDelivery(@RequestBody Delivery delivery,
                              @PathVariable("deliveryId") Long deliveryId) throws ChangeSetPersister.NotFoundException, NotFoundException {
        service.update(deliveryId, delivery);
    }

    @DeleteMapping(value = "/{deliveryId}")
    public void deleteDelivery(@PathVariable("deliveryId") Long deliveryId) throws ChangeSetPersister.NotFoundException {
        service.delete(deliveryId);
    }

}

