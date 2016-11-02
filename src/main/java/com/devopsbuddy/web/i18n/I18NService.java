package com.devopsbuddy.web.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by Jonathan on 11/2/2016.
 */

@Service
public class I18NService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String messageId) {
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageId, locale);
    }

    public String getMessage(String messageId, Locale locale) {
        return  messageSource.getMessage(messageId, null, locale);
    }

}
