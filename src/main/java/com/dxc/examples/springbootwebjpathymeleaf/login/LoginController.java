package com.dxc.examples.springbootwebjpathymeleaf.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger( LoginController.class );
	
	@GetMapping("/login")
	public String getlogin( Model model ) {
		model.addAttribute( "loginForm", new LoginDTO() );
		return "login";
	}
	
	@PostMapping("/login")
	private String postLogin( @ModelAttribute LoginDTO loginForm ) {
		return "index";
	}

}
