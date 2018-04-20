package br.com.abutres.controller;

import java.util.List;

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
		ModelAndView mv = new ModelAndView("views/estados/listar");
		mv.addObject("estados", estados.findAll());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView adicionar(Estado estado) {
		ModelAndView mv = new ModelAndView("views/estados/adicionar");
		return mv;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("views/estados/adicionar");
		if (result.hasErrors()) {
			mv.addObject("msg_error", "Verifique os erros.");
			return mv;
		}
		this.estados.salvar(estado);	
		
		mv.addObject("msg_sucess", "Estado salvo com sucesso.");
		return mv;
		
	}
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Estado estado = estados.findById(id);
		ModelAndView mv = new ModelAndView("views/estados/exibir");
		mv.addObject("estado", estado);
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Estado estado = estados.findById(id);
		ModelAndView mv = new ModelAndView("views/estados/editar");
		mv.addObject("estado", estado);
		return mv;
	}
	
}
