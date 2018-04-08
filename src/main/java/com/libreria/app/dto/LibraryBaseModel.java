package com.libreria.app.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by HP on 08/04/2018.
 */
public class LibraryBaseModel extends ModelAndView {

    public LibraryBaseModel(String view, String title){
        super(view);
        this.addObject("title", title);
        this.addObject("view", view);
    }

    public LibraryBaseModel(){
        super();
    }
}
