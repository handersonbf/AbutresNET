package br.com.abutres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
		ModelAndView modelAndView = new ModelAndView("views/paises/listar");
		modelAndView.addObject("paises", paises.listaTodos());
		return modelAndView;
	}	

	@GetMapping("/adicionar")
	public ModelAndView adicionar(Pais pais) {
		ModelAndView modelAndView = new ModelAndView("views/paises/adicionar");
		modelAndView.addObject(pais);
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Pais pais, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return adicionar(pais);
		}
		this.paises.salvar(pais);			
		attributes.addFlashAttribute("msg_sucess", "Pais salvo com sucesso.");
		return new ModelAndView("redirect:/paises/");
	}
		
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionar(paises.findById(id));
	}	
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		paises.remover(id);	
		attributes.addFlashAttribute("msg_sucess", "Pais removido com sucesso.");
		return "redirect:/paises";
	}	
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Pais pais = paises.findById(id);
		ModelAndView modelAndView = new ModelAndView("views/paises/exibir");
		modelAndView.addObject("pais", pais);
		return modelAndView;
	}	
}
