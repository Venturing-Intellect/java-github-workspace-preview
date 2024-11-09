package com.example.feedback.controller;

import com.example.feedback.dto.FeedbackDTO;
import com.example.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public String submitFeedback(@Valid @RequestBody FeedbackRequest feedbackRequest) {
        if (!isValidEmail(feedbackRequest.getEmail())) {
            return "Invalid email format";
        }
        FeedbackDTO feedbackDTO = new FeedbackDTO(feedbackRequest.getEmail(), feedbackRequest.getFeedback());
        feedbackService.saveFeedback(feedbackDTO);
        return "Feedback submitted successfully";
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static class FeedbackRequest {
        @Email
        @NotBlank
        private String email;

        @NotBlank
        private String feedback;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }
    }
}
