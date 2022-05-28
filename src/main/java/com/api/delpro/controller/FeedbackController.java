package com.api.delpro.controller;

import com.api.delpro.model.Delivery;
import com.api.delpro.model.Feedback;
import com.api.delpro.service.DeliveryServiceImpl;
import com.api.delpro.service.FeedbackServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackServiceImpl service;

    @GetMapping("/all")
    public List<Feedback> listAllFeedbacks() {
        return service.findAllFeedbacks();
    }

    @GetMapping(value = "/{feedbackId}")
    public Optional<Feedback> getFeedback(@PathVariable("feedbackId") Long feedbackId) throws EntityNotFoundException, ChangeSetPersister.NotFoundException {
        return service.findById(feedbackId);
    }

    @PostMapping
    public void createFeedback(@RequestBody Feedback feedback) {
        service.save(feedback);
    }

    @PutMapping(value = "/{feedbackId}")
    public void updateFeedback(@RequestBody Feedback feedback,
                               @PathVariable("feedbackId") Long feedbackId) throws ChangeSetPersister.NotFoundException, NotFoundException {
        service.update(feedbackId, feedback);
    }

    @DeleteMapping(value = "/{feedbackId}")
    public void deleteFeedback(@PathVariable("feedbackId") Long feedbackId) throws ChangeSetPersister.NotFoundException {
        service.delete(feedbackId);
    }

}

