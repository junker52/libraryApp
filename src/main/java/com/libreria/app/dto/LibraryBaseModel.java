package com.libreria.app.dto;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.globals.PageNameGlobals;
import com.libreria.app.utils.MessageGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by HP on 08/04/2018.
 */
public class LibraryBaseModel extends ModelAndView {

    private String title;


    public LibraryBaseModel(String view, String title){
        super(view);

        this.addObject("title", title);
        this.addObject("view", view);

    }

    public LibraryBaseModel(){
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
