package com.api.delpro.service;

import com.api.delpro.model.Address;
import com.api.delpro.model.Price;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface PriceService {

    public Optional<Price> findById(long priceId);

    public void save(Price price);

    public void update(long priceId, Price price) throws NotFoundException;

    public List<Price> findAllPrices();

    public void delete(long priceId);
}
