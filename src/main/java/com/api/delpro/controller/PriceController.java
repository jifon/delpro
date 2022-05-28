package com.api.delpro.controller;

import com.api.delpro.model.Address;
import com.api.delpro.model.Price;
import com.api.delpro.service.AddressServiceImpl;
import com.api.delpro.service.PriceServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    @Autowired
    private PriceServiceImpl service;

    @GetMapping("/all")
    public List<Price> listAllPrice() {
        return service.findAllPrices();
    }

    @GetMapping(value = "/{priceId}")
    public Optional<Price> getPrice(@PathVariable("priceId") Long priceId) throws EntityNotFoundException, ChangeSetPersister.NotFoundException {
        return service.findById(priceId);
    }

    @PostMapping
    public void createPrice(@RequestBody Price price) {
        service.save(price);
    }

    @PutMapping(value = "/{priceId}")
    public void updatePrice(@RequestBody Price price,
                              @PathVariable("priceId") Long priceId) throws ChangeSetPersister.NotFoundException, NotFoundException {
        service.update(priceId, price);
    }

    @DeleteMapping(value = "/{priceId}")
    public void deletePrice(@PathVariable("priceId") Long addressId) throws ChangeSetPersister.NotFoundException {
        service.delete(addressId);
    }

}

