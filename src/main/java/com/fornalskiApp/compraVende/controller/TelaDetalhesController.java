package com.fornalskiApp.compraVende.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.fornalskiApp.compraVende.models.Carro;
import com.fornalskiApp.compraVende.repositories.CarroRepository;

@Controller
public class TelaDetalhesController {
	
	@Autowired
	CarroRepository carroRepository;

	@GetMapping("/detalhes/{iddetalhes}")
	public ModelAndView Detalhes(@PathVariable("iddetalhes") Long iddetalhes) {
		Optional<Carro> carros = carroRepository.findById(iddetalhes);
		ModelAndView mv = new ModelAndView("Carros/detalhes");
		mv.addObject("Detalhes", carros.get());		
		return mv;
	}
}
