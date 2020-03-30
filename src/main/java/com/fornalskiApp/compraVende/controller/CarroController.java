package com.fornalskiApp.compraVende.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fornalskiApp.compraVende.models.Carro;
import com.fornalskiApp.compraVende.repositories.CarroRepository;

@Controller
public class CarroController {

	@Autowired
	CarroRepository carroRepository;
	
//DIRECIONAMENTO PAGINA ADICIONAR CARRO
	@GetMapping(value = "/addCar")
	 public ModelAndView pageCar() {		
		ModelAndView mv = new ModelAndView("Carros/addCarro.html");
		
		return mv;
	}
	

//DIRECIONAMENTO DE LISTA CARROS	
	@GetMapping(value ="/lista-de-carros")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("Carros/ListaCarro.html");
		Iterable<Carro> carros = carroRepository.findAll();
		mv.addObject("ListaCarros", carros);
				
		
		return mv;
	}
	
	
//DIRECIONAMENTO SALVAR CARRO COM FOTOS		
	@PostMapping(value = "/saveCar")
	public String saveCar(Carro carro, @RequestParam("imageOne") MultipartFile file1,
			                           @RequestParam("imageTwo") MultipartFile file2,
			                           @RequestParam("imageThree") MultipartFile file3,
			                           @RequestParam("imageFour") MultipartFile file4,
			                           @RequestParam("imageFive") MultipartFile file5) throws IOException  {
		
		carro.setImage1(file1.getBytes());
		carro.setImage2(file2.getBytes());
		carro.setImage3(file3.getBytes());
		carro.setImage4(file4.getBytes());
		carro.setImage5(file5.getBytes());
				
		
		carroRepository.save(carro);		
		
		return "redirect:/lista-de-carros";
		
	}
	
//LISTA CARROS COM FOTOS	
	@GetMapping("/imagem/{idprod}")
	@ResponseBody
	public byte[] exibirImagen1(@PathVariable("idprod") Long idprod) {
		Carro carro = carroRepository.getOne(idprod);
		return carro.getImage1();
	}
	@GetMapping("/imagem2/{idpro}")
	@ResponseBody
	public byte[] exibirImagen2(@PathVariable("idpro") Long idpro) {
		Carro carro = carroRepository.getOne(idpro);
		return carro.getImage2();
	}
	@GetMapping("/imagem3/{idpr}")
	@ResponseBody
	public byte[] exibirImagen3(@PathVariable("idpr") Long idpr) {
		Carro carro = carroRepository.getOne(idpr);
		return carro.getImage3();
	}
	@GetMapping("/imagem4/{idp}")
	@ResponseBody
	public byte[] exibirImagen4(@PathVariable("idp") Long idp) {
		Carro carro = carroRepository.getOne(idp);
		return carro.getImage4();
	}
	@GetMapping("/imagem5/{idprodu}")
	@ResponseBody
	public byte[] exibirImagen5(@PathVariable("idprodu") Long idprodu) {
		Carro carro = carroRepository.getOne(idprodu);
		return carro.getImage5();
	}	
	
//DELETE CARROS
	@GetMapping(value = "/deletar-carro/{delCar}")
	public String deletarCarro(@PathVariable("delCar")Long id) {
		
		carroRepository.deleteById(id);						
		
		
		return "redirect:/lista-de-carros";
		
	}
	
//PESQUISA
	@PostMapping(value = "**/pesquisar")
	public ModelAndView pesquisar(@RequestParam("PesquisaVeiculo") String PesquisaVeiculo) {
		
		ModelAndView mv = new ModelAndView("Carros/ListaCarro.html");
		mv.addObject("ListaCarros",carroRepository.findCarroByName(PesquisaVeiculo));
		
		return mv;
	}
	

	
}
















