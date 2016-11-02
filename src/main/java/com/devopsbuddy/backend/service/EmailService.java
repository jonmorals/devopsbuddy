package com.devopsbuddy.backend.service;

import com.devopsbuddy.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Jonathan on 11/2/2016.
 */
public interface EmailService {

    void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    void sendGenericEmail(SimpleMailMessage message);
}
