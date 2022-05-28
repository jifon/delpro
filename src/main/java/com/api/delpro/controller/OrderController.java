package com.api.delpro.controller;

import com.api.delpro.model.Address;
import com.api.delpro.model.Order;
import com.api.delpro.service.AddressServiceImpl;
import com.api.delpro.service.OrderServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl service;

    @GetMapping("/all")
    public List<Order> listAllOrders() {
        return service.findAllOrders();
    }

    @GetMapping(value = "/{orderId}")
    public Optional<Order> getOrder(@PathVariable("orderId") Long orderId) throws EntityNotFoundException, ChangeSetPersister.NotFoundException {
        return service.findById(orderId);
    }

    @PostMapping
    public void createAOrders(@RequestBody Order order) {
        service.save(order);
    }

    @PutMapping(value = "/{orderId}")
    public void updateOrders(@RequestBody Order order,
                              @PathVariable("orderId") Long orderId) throws ChangeSetPersister.NotFoundException, NotFoundException {
        service.update(orderId, order);
    }

    @DeleteMapping(value = "/{orderId}")
    public void deleteOrders(@PathVariable("orderId") Long orderId) throws ChangeSetPersister.NotFoundException {
        service.delete(orderId);
    }

}
