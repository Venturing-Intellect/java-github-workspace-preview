package com.example.feedback.controller;

import com.example.feedback.dto.FeedbackDTO;
import com.example.feedback.service.FeedbackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@WebMvcTest(FeedbackController.class)
public class FeedbackControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FeedbackService feedbackService;

    @Test
    public void testSubmitFeedback() throws Exception {
        String email = "test@example.com";
        String feedback = "This is a test feedback";

        FeedbackDTO feedbackDTO = new FeedbackDTO(email, feedback);
        when(feedbackService.saveFeedback(feedbackDTO)).thenReturn(feedbackDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/feedback")
                .contentType("application/json")
                .content("{\"email\":\"" + email + "\", \"feedback\":\"" + feedback + "\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Feedback submitted successfully"));

        verify(feedbackService, times(1)).saveFeedback(feedbackDTO);
    }
}
