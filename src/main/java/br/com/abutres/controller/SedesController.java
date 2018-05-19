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
import br.com.abutres.model.Pais;
import br.com.abutres.model.Sede;
import br.com.abutres.service.CidadesService;
import br.com.abutres.service.EstadosService;
import br.com.abutres.service.PaisesService;
import br.com.abutres.service.SedesService;

@Controller
@RequestMapping("/sedes")
public class SedesController {
	
	@Autowired
	private SedesService sedes;
	
	@Autowired
	private PaisesService paisesService;
	
	@Autowired
	private EstadosService estadosService;
	
	@Autowired
	private CidadesService cidadesService;
	
	
	@ModelAttribute("listaTodosPaises")
	public List<Pais> listaTodosPaises(){
		return this.paisesService.listaTodos();
	}
	
	@ModelAttribute("listaTodosEstados")
	public List<Estado> listaTodosEstados(){
		return this.estadosService.listaTodos();
	}
	
	@ModelAttribute("listaTodosCidades")
	public List<Cidade> listaTodosCidades(){
		return this.cidadesService.listaTodos();
	}
	
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("views/sedes/listar");
		modelAndView.addObject("sedes", sedes.listaTodos());
		return modelAndView;
	}	
	
	@GetMapping("/adicionar")
	public ModelAndView adicionar(Sede sede) {
		ModelAndView modelAndView = new ModelAndView("views/sedes/adicionar");
		modelAndView.addObject(sede);
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Sede sede, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return adicionar(sede);
		}
		this.sedes.salvar(sede);			
		attributes.addFlashAttribute("msg_sucess", "Sede salvo com sucesso.");
		return new ModelAndView("redirect:/sedes/");
	}
		
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionar(sedes.buscaPorId(id));
	}	
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		sedes.remover(id);	
		attributes.addFlashAttribute("msg_sucess", "Sede removido com sucesso.");
		return "redirect:/sedes";
	}	
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Sede sede = sedes.buscaPorId(id);
		ModelAndView modelAndView = new ModelAndView("views/sedes/exibir");
		modelAndView.addObject("sede", sede);
		return modelAndView;
	}		
}
