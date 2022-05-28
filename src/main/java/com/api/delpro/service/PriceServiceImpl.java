package com.api.delpro.service;

import com.api.delpro.dao.AddressRepository;
import com.api.delpro.dao.PriceRepository;
import com.api.delpro.model.Order;
import com.api.delpro.model.Price;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PriceServiceImpl implements PriceService{

    @Autowired
    private PriceRepository repository;

    @Override
    public Optional<Price> findById(long priceId) {
        return repository.findById(priceId);
    }

    @Override
    public void save(Price price) {
        repository.save(price);

    }

    @Override
    public void update(long priceId, Price price) throws NotFoundException {
        Price price1 = repository.findById(priceId).orElseThrow(() -> new NotFoundException("Don't have price - " + priceId));
        repository.save(price1);
    }

    @Override
    public List<Price> findAllPrices() {
        return repository.findAll();
    }

    @Override
    public void delete(long priceId) {
        repository.deleteById(priceId);

    }
}
