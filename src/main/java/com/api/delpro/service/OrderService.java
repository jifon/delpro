package com.api.delpro.service;

import com.api.delpro.model.Address;
import com.api.delpro.model.Order;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Optional<Order> findById(long orderId);

    public void save(Order order);

    public void update(long orderId, Order order) throws NotFoundException;

    public List<Order> findAllOrders();

    public void delete(long orderId);
}
