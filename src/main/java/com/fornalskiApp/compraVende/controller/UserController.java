package com.fornalskiApp.compraVende.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fornalskiApp.compraVende.models.User;
import com.fornalskiApp.compraVende.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/user")
	public ModelAndView Login(){
		ModelAndView mv = new ModelAndView("Usuario/cadastroUser.html");		
		return mv;
	}
  //SALVANDO USUARIO	
	@PostMapping(value = "*/salvarUser")
	public String saveUser(User user) {		
		userRepository.save(user);		
		ModelAndView mv = new ModelAndView("Usuario/cadastroUser.html");
		mv.addObject("userObj");
		
		
		return "redirect:/lista-de-usuarios";
		
	}
	
	// LISTA USUARIOS	
		@GetMapping(value ="/lista-de-usuarios")
		public ModelAndView listaUser() {
			ModelAndView mv = new ModelAndView("Usuario/listaUser.html");
			Iterable<User> users = userRepository.findAll();
			mv.addObject("ListaUsuario", users);
					
			
			return mv;
		}
	//DELETE USUARIO	
		@GetMapping(value = "/deleteUser/{id}")
		public String deleteUser(@PathVariable("id")Long id) {
			
			userRepository.deleteById(id);
			
			return"redirect:/lista-de-usuarios";
		}
		
		@GetMapping(value = "/editarUser/{id}")
		public ModelAndView editarUser(@PathVariable("id")Long id) {

			Optional<User> user = userRepository.findById(id);			
			ModelAndView mv = new ModelAndView("Usuario/cadastroUser.html");
			mv.addObject("userObj", user.get());
			
			return mv;
		}
		
}






















