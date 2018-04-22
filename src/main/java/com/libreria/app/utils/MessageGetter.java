package com.libreria.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by HP on 22/04/2018.
 */
@Component
public class MessageGetter {

    @Autowired
    private MessageGetter messageGetter;

    public String getMessage(String code) {
        return messageGetter.getMessage(code);
    }


}
