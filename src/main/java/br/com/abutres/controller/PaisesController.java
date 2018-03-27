package br.com.abutres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.abutres.model.Pais;
import br.com.abutres.service.PaisesService;

@Controller
public class PaisesController {
	
	@Autowired
	private PaisesService paises;
	
	@GetMapping("/paises")
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("views/paises/listar");
		view.addObject("paises", paises.findAll());
		return view;
	}
	
	@GetMapping("/paises/adicionar")
	public ModelAndView adicionar() {
		ModelAndView view = new ModelAndView("views/paises/adicionar");
		view.addObject(new Pais());
		return view;
	}
	
	@PostMapping("/paises/adicionar")
	public String adicionar(Pais pais) {
		this.paises.salvar(pais);
		return "redirect:/paises";
	}
	
	@GetMapping("/paises/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Pais pais = paises.findById(id);
		ModelAndView view = new ModelAndView("views/paises/exibir");
		view.addObject("pais", pais);
		return view;
	}
	
}
