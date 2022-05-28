package com.api.delpro.controller;

import com.api.delpro.model.Address;
import com.api.delpro.service.AddressService;
import com.api.delpro.service.AddressServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl service;

    @GetMapping("/all")
    public List<Address> listAllAddresses() {
        return service.findAllAddresses();
    }

    @GetMapping(value = "/{addressId}")
    public Optional<Address> getAddress(@PathVariable("addressId") Long addressId) throws EntityNotFoundException, ChangeSetPersister.NotFoundException {
        return service.findById(addressId);
    }

    @PostMapping
    public void createAddress(@RequestBody Address address) {
         service.save(address);
    }

    @PutMapping(value = "/{addressId}")
    public void updateAddress(@RequestBody Address address,
                                  @PathVariable("addressId") Long addressId) throws ChangeSetPersister.NotFoundException, NotFoundException {
        service.update(addressId, address);
    }

    @DeleteMapping(value = "/{addressId}")
    public void deleteAddress(@PathVariable("addressId") Long addressId) throws ChangeSetPersister.NotFoundException {
        service.delete(addressId);
    }

}

