package com.api.delpro.service;

import com.api.delpro.model.Address;
import com.api.delpro.model.Delivery;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    public Optional<Delivery> findById(long deliveryId);

    public void save(Delivery delivery);

    public void update(long deliveryId, Delivery delivery) throws NotFoundException;

    public List<Delivery> findAllDeliveries();

    public void delete(long deliveryId);
}
