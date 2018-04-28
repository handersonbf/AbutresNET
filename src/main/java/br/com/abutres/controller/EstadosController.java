package br.com.abutres.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abutres.model.Estado;
import br.com.abutres.model.Pais;
import br.com.abutres.service.EstadosService;
import br.com.abutres.service.PaisesService;

@Controller
@RequestMapping("/estados")
public class EstadosController {
	
	@Autowired
	private EstadosService estados;
	
	@Autowired
	private PaisesService paises;
	
	@ModelAttribute("listaTodosPaises")
	public List<Pais> listaTodosPaises(){
		return this.paises.listaTodos();
	}
		
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("views/estados/listar");
		modelAndView.addObject("estados", estados.listaTodos());
		return modelAndView;
	}	

	@GetMapping("/adicionar")
	public ModelAndView adicionar(Estado estado) {
		ModelAndView modelAndView = new ModelAndView("views/estados/adicionar");
		modelAndView.addObject(estado);
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return adicionar(estado);
		}
		this.estados.salvar(estado);			
		attributes.addFlashAttribute("msg_sucess", "Estado salvo com sucesso.");
		return new ModelAndView("redirect:/estados/");
	}
		
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionar(estados.buscaPorId(id));
	}	
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		estados.remover(id);	
		attributes.addFlashAttribute("msg_sucess", "Estado removido com sucesso.");
		return "redirect:/estados";
	}	
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Estado estado = estados.buscaPorId(id);
		ModelAndView modelAndView = new ModelAndView("views/estados/exibir");
		modelAndView.addObject("estado", estado);
		return modelAndView;
	}	
}