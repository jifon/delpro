package com.api.delpro.service;

import com.api.delpro.dao.AddressRepository;
import com.api.delpro.dao.DeliveryRepository;
import com.api.delpro.model.Address;
import com.api.delpro.model.Delivery;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    private DeliveryRepository repository;

    @Override
    public Optional<Delivery> findById(long deliveryId) {
        return repository.findById(deliveryId);
    }

    @Override
    public void save(Delivery delivery) {
        repository.save(delivery);
    }

    @Override
    public void update(long deliveryId, Delivery delivery) throws NotFoundException {
        Delivery delivery1 = repository.findById(deliveryId).orElseThrow(() -> new NotFoundException("Don't have delivery - " + deliveryId));
        repository.save(delivery1);
    }

    @Override
    public List<Delivery> findAllDeliveries() {

        return repository.findAll();
    }

    @Override
    public void delete(long deliveryId) {
        repository.deleteById(deliveryId);
    }
}
