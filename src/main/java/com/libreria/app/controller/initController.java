package com.libreria.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class initController {
	
	public final String INITIAL_VIEW = "init";
	
	@GetMapping("/")
	public ModelAndView initialView() {
		return this.setBasicView(INITIAL_VIEW);
	}

	
	private ModelAndView setBasicView(String view) {
		return new ModelAndView(view);
	}
}
