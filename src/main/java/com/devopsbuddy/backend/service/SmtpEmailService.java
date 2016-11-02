package com.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Jonathan on 11/2/2016.
 */
public class SmtpEmailService extends AbstractEmailService {

    /** the application logger */
    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendGenericEmail(SimpleMailMessage message) {
        LOG.debug("sending email for {}", message);
        mailSender.send(message);
        LOG.info("Email sent.");
    }
}
