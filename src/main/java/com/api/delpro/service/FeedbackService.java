package com.api.delpro.service;

import com.api.delpro.model.Address;
import com.api.delpro.model.Feedback;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {

    public Optional<Feedback> findById(long feedbackId);

    public void save(Feedback feedback);

    public void update(long feedbackId, Feedback feedback) throws NotFoundException;

    public List<Feedback> findAllFeedbacks();

    public void delete(long feedbackId);
}
