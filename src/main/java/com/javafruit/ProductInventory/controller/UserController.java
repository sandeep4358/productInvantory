package com.javafruit.ProductInventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class UserController {
	private Logger log = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showLoginPage() {
    	log.info("entry");
	return "index";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
    	log.info("entry");
	return "welcome";
    }
    
/*
 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
 * showWelcomePage(ModelMap model,
 * 
 * @RequestParam String name, @RequestParam String password) { boolean
 * isValidUser = service.validateUser(name, password); if (!isValidUser) {
 * model.put("errorMessage", "Invalid Credentials"); return "login"; }
 * model.put("name", name); model.put("password", password); return "welcome"; }
 * }
 */
}