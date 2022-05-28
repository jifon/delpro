package com.api.delpro.service;

import com.api.delpro.model.Address;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    public Optional<Address> findById(long addressId);

    public void save(Address address);

    public void update(long addressId,Address address) throws NotFoundException;

    public List<Address> findAllAddresses();

    public void delete(long addressId);
}
