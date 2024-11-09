package com.example.feedback.service;

import com.example.feedback.dto.FeedbackDTO;
import com.example.feedback.model.FeedbackEntity;
import com.example.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void saveFeedback(FeedbackDTO feedbackDTO) {
        FeedbackEntity feedbackEntity = new FeedbackEntity(feedbackDTO.getEmail(), feedbackDTO.getFeedback());
        feedbackRepository.save(feedbackEntity);
    }

    public FeedbackDTO getFeedback(Long id) {
        FeedbackEntity feedbackEntity = feedbackRepository.findById(id).orElse(null);
        if (feedbackEntity != null) {
            return new FeedbackDTO(feedbackEntity.getEmail(), feedbackEntity.getFeedbackText());
        }
        return null;
    }
}
