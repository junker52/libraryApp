package com.libreria.app.controller;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.dto.LibraryBaseModel;
import com.libreria.app.globals.PageNameGlobals;
import com.libreria.app.model.Autor;
import com.libreria.app.model.Libro;
import com.libreria.app.repository.AutorRepository;
import com.libreria.app.repository.LibroRepository;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
public class InitController {

	public final String INITIAL_VIEW = "init";

	@Autowired
	private LibrarySessionContext sessionContext;

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
	public LibraryBaseModel initialView() {
		logger.info("Init View Controller");
		LibraryBaseModel lbm = new LibraryBaseModel(INITIAL_VIEW, PageNameGlobals.INIT_PAGE);
		lbm.addObject("sessionContext",sessionContext);
		return lbm;
	}


}