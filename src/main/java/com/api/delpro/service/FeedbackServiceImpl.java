package com.api.delpro.service;

import com.api.delpro.dao.AddressRepository;
import com.api.delpro.dao.FeedbackRepository;
import com.api.delpro.model.Address;
import com.api.delpro.model.Delivery;
import com.api.delpro.model.Feedback;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackRepository repository;

    @Override
    public Optional<Feedback> findById(long feedbackId) {
        return repository.findById(feedbackId);
    }

    @Override
    public void save(Feedback feedback) {
        repository.save(feedback);

    }

    @Override
    public void update(long feedbackId, Feedback feedback) throws NotFoundException {
        Feedback feedback1 = repository.findById(feedbackId).orElseThrow(() -> new NotFoundException("Don't have feedback - " + feedbackId));
        repository.save(feedback1);
    }

    @Override
    public List<Feedback> findAllFeedbacks() {
        return repository.findAll();
    }

    @Override
    public void delete(long feedbackId) {
        repository.deleteById(feedbackId);

    }
}
