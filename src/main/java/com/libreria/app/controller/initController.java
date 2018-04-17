package com.libreria.app.controller;

import com.libreria.app.configuration.LibrarySessionContext;
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
public class initController {

	public final String INITIAL_VIEW = "init";

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(initController.class);

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private LibrarySessionContext sessionContext;

	@GetMapping("/")
	public ModelAndView initialView() {
		ModelAndView mav = new ModelAndView(INITIAL_VIEW);
		mav.addObject("sessionContext", sessionContext);
		return mav;
	}


}