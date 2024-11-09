package com.example.feedback.dto;

public class FeedbackDTO {
    private String email;
    private String feedback;

    public FeedbackDTO(String email, String feedback) {
        this.email = email;
        this.feedback = feedback;
    }

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
