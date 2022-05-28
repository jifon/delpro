package com.api.delpro.service;

import javassist.NotFoundException;
import com.api.delpro.dao.AddressRepository;
import com.api.delpro.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository repository;

    @Override
    public Optional<Address> findById(long addressId) {
        return repository.findById(addressId);
    }

    @Override
    public void save(Address address) {
        repository.save(address);
    }

    @Override
    public void update(long addressId,Address address) throws NotFoundException {
        Address address1 = repository.findById(addressId).orElseThrow(() -> new NotFoundException("Don't have address - " + addressId));
        repository.save(address1);
    }

    @Override
    public List<Address> findAllAddresses() {
        return repository.findAll();
    }

    @Override
    public void delete(long addressId) {
        repository.deleteById(addressId);
    }
}
