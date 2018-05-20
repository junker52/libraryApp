
package com.libreria.app.controller;

import javax.validation.Valid;

import com.libreria.app.dto.LibraryBaseModel;
import com.libreria.app.globals.PageNameGlobals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.libreria.app.model.User;
import com.libreria.app.service.UserService;

@Controller
public class loginController {
	
	private final static String REGISTRO_VIEW = "registro";
	private final static String LOGIN_VIEW = "login";
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public LibraryBaseModel login(){
		LibraryBaseModel modelAndView = new LibraryBaseModel(LOGIN_VIEW, PageNameGlobals.LOGIN_PAGE);
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registro", method = RequestMethod.GET)
	public LibraryBaseModel registration(){
		LibraryBaseModel modelAndView = new LibraryBaseModel(REGISTRO_VIEW, PageNameGlobals.REGISTRO_PAGE);
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public LibraryBaseModel createNewUser(@Valid User user, BindingResult bindingResult) {
		LibraryBaseModel modelAndView = new LibraryBaseModel(REGISTRO_VIEW, PageNameGlobals.REGISTRO_PAGE);
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (!bindingResult.hasErrors()) {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			
		}
		return modelAndView;
	}
	
	/*
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	*/
}
