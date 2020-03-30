package com.fornalskiApp.compraVende.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fornalskiApp.compraVende.models.User;
import com.fornalskiApp.compraVende.repositories.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/login")
	public ModelAndView Login(){
		ModelAndView mv = new ModelAndView("Login/login.html");		
		return mv;
	}
	
	@PostMapping(value = "/logar")
	public String login(User user) {
		
		if (user.getEmail().equals("admin@gmail.com") && user.getSenha().equals("1234")) {
			
			return "redirect:/addCar";
			
		}else {
			
			return "redirect:/login";

		}
		
				
	}
}













