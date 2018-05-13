package br.com.abutres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abutres.model.Sede;
import br.com.abutres.service.SedesService;

@Controller
public class SedesController {
	
	@Autowired
	private SedesService sedesService;
	
	private static final String ADICIONAR_SEDE_VIEW = "views/sedes/adicionar";
	
	
	@GetMapping("/sedes")
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("views/sedes/listar");
		view.addObject("sedes", sedesService.findAll());
		return view;
	}
	
	@GetMapping("/sedes/adicionar")
	public ModelAndView adicionar() {
		ModelAndView view = new ModelAndView("views/sedes/adicionar");
		view.addObject(new Sede());
		return view;
	}
	
	@PostMapping("/sedes/adicionar")
	public String adicionar(@Valid Sede sede, Errors err, RedirectAttributes att) {
		if(err.hasErrors()) {
			System.out.println("erro ---> "+err.getAllErrors());
			return ADICIONAR_SEDE_VIEW;
		}
		
		this.sedesService.salvar(sede);
		att.addFlashAttribute("msg-success", "Titulo salvo com sucesso!");
		return "redirect:/sedes";
	}
	
	@GetMapping("/sedes/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Sede sede = sedesService.findById(id);
		ModelAndView view = new ModelAndView("views/sedes/exibir");
		view.addObject("sede", sede);
		return view;
	}
	
	@DeleteMapping("/sedes/remover/{id}")
	public String remover(@PathVariable Long id, Errors err, RedirectAttributes att) {
		if(!err.hasErrors()) {
			sedesService.remover(id);
		}else {
			System.out.println("----> "+err.getAllErrors());
		}
		
		return "redirect:/sedes";
	}
}
