package com.api.delpro.dao;


import com.api.delpro.model.Address;
import com.api.delpro.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}

