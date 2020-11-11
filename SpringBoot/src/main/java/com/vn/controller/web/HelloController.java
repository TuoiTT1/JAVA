package com.vn.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

	@RequestMapping(value = {"", "/", "/index", "/home"})
	public ModelAndView index() {
		return new ModelAndView("homePage");
	}
}
