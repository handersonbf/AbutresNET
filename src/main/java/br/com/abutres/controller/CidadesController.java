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

import br.com.abutres.model.Cidade;
import br.com.abutres.model.Estado;
import br.com.abutres.service.CidadesService;
import br.com.abutres.service.EstadosService;

@Controller
@RequestMapping("/cidades")
public class CidadesController {
	
	@Autowired
	private CidadesService cidades;
	
	@Autowired
	private EstadosService estados;
	
	@ModelAttribute("listaTodosEstados")
	public List<Estado> listaTodosEstados(){
		return this.estados.listaTodos();
	}
		
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("views/cidades/listar");
		modelAndView.addObject("cidades", cidades.listaTodos());
		return modelAndView;
	}	

	@GetMapping("/adicionar")
	public ModelAndView adicionar(Cidade cidade) {
		ModelAndView modelAndView = new ModelAndView("views/cidades/adicionar");
		modelAndView.addObject(cidade);
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return adicionar(cidade);
		}
		this.cidades.salvar(cidade);			
		attributes.addFlashAttribute("msg_sucess", "Cidade salvo com sucesso.");
		return new ModelAndView("redirect:/cidades/");
	}
		
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionar(cidades.buscaPorId(id));
	}	
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		cidades.remover(id);	
		attributes.addFlashAttribute("msg_sucess", "Cidade removido com sucesso.");
		return "redirect:/cidades";
	}	
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Cidade cidade = cidades.buscaPorId(id);
		ModelAndView modelAndView = new ModelAndView("views/cidades/exibir");
		modelAndView.addObject("cidade", cidade);
		return modelAndView;
	}	
}