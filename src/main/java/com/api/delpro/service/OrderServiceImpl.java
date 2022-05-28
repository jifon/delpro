package com.api.delpro.service;

import com.api.delpro.dao.AddressRepository;
import com.api.delpro.dao.OrderRepository;
import com.api.delpro.model.Feedback;
import com.api.delpro.model.Order;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repository;

    @Override
    public Optional<Order> findById(long orderId) {
        return repository.findById(orderId);
    }

    @Override
    public void save(Order order) {
        repository.save(order);

    }

    @Override
    public void update(long orderId, Order order) throws NotFoundException {
        Order order1 = repository.findById(orderId).orElseThrow(() -> new NotFoundException("Don't have order - " + orderId));
        repository.save(order1);
    }

    @Override
    public List<Order> findAllOrders() {
        return repository.findAll();
    }

    @Override
    public void delete(long orderId) {
        repository.deleteById(orderId);

    }
}
