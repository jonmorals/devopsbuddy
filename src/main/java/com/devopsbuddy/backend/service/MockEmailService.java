package com.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Jonathan on 11/2/2016.
 */

public class MockEmailService extends AbstractEmailService {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendGenericEmail(SimpleMailMessage message) {
        LOG.debug("Simulating an email service...");
        LOG.info(message.toString());
        LOG.debug("Email sent.");
    }
}
