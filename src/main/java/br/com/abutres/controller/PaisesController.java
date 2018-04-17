package br.com.abutres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abutres.model.Pais;
import br.com.abutres.service.PaisesService;

@Controller
@RequestMapping("/paises")
public class PaisesController {
	
	@Autowired
	private PaisesService paises;
		
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("views/paises/listar");
		mv.addObject("paises", paises.listaTodos());
		return mv;
	}
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Pais pais = paises.findById(id);
		ModelAndView mv = new ModelAndView("views/paises/exibir");
		mv.addObject("pais", pais);
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView adicionar(Pais pais) {
		ModelAndView mv = new ModelAndView("views/paises/adicionar");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Pais pais = paises.findById(id);
		ModelAndView mv = new ModelAndView("views/paises/editar");
		mv.addObject("pais", pais);
		return mv;
	}	
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Pais pais, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("views/paises/adicionar");
		if (result.hasErrors()) {
			mv.addObject("msg_error", "Verifique os erros.");
			return mv;
		}
		this.paises.salvar(pais);	
		mv.setViewName("redirect:/paises/");
		attributes.addFlashAttribute("msg_sucess", "Pais salvo com sucesso.");
		return mv;
		
	}
	
	@PostMapping("/remover")
	public ModelAndView remover(long id) {
		paises.remover(id);
		return new ModelAndView("redirect:/paises/");
	}
	
	/*
	 * novo
	 * salvar
	 * 
	 * */
}
