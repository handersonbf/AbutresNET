package br.com.abutres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.abutres.model.Estado;
import br.com.abutres.service.EstadosService;

@Controller
public class EstadosController {
	
	@Autowired
	private EstadosService estados;
		
	@GetMapping("/estados")
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("views/estados/listar");
		view.addObject("estados", estados.findAll());
		return view;
	}
	
	@GetMapping("/estados/adicionar")
	public ModelAndView adicionar() {
		ModelAndView view = new ModelAndView("views/estados/adicionar");
		view.addObject(new Estado());
		return view;
	}
	
	@PostMapping("/estados/adicionar")
	public String adicionar(Estado estado) {
		this.estados.salvar(estado);
		return "redirect:/estados";
	}
	
	@GetMapping("/estados/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Estado estado = estados.findById(id);
		ModelAndView view = new ModelAndView("views/estados/exibir");
		view.addObject("estado", estado);
		return view;
	}
	
}
