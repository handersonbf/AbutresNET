package br.com.abutres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abutres.model.Estado;
import br.com.abutres.service.EstadosService;
import br.com.abutres.service.PaisesService;

@Controller
public class EstadosController {
	
	@Autowired
	private EstadosService estados;
	
	@Autowired
	private PaisesService paises;
		
	@GetMapping("/estados")
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("views/estados/listar");
		view.addObject("estados", estados.findAll());
		return view;
	}
	
	@GetMapping("/estados/adicionar")
	public ModelAndView adicionar(Estado estado) {
		ModelAndView view = new ModelAndView("views/estados/adicionar");
		view.addObject("paises", paises.findAll()); 
		return view;
	}
	
	@PostMapping("/estados/adicionar")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result
			, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return this.adicionar(estado);
		}
		this.estados.salvar(estado);
		
		ModelAndView mv = new ModelAndView("redirect:/estados/adicionar");
		attributes.addFlashAttribute("mensagem", "Estado salvo com sucesso.");
		return mv;
	}
	
	@GetMapping("/estados/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Estado estado = estados.findById(id);
		ModelAndView view = new ModelAndView("views/estados/exibir");
		view.addObject("estado", estado);
		return view;
	}
	
	@GetMapping("/estados/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Estado estado = estados.findById(id);
		ModelAndView view = new ModelAndView("views/estados/editar");
		view.addObject("estado", estado);
		return view;
	}
	
}
