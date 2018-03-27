package br.com.abutres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.abutres.model.Sede;
import br.com.abutres.service.SedesService;

@Controller
public class SedesController {
	
	@Autowired
	private SedesService sedesService;
	
	
	@GetMapping("/sedes")
	public ModelAndView lista() {
		ModelAndView view = new ModelAndView("views/sedes/lista");
		view.addObject("sedes", sedesService.findAll());
		return view;
	}
	
	@GetMapping("/sedes/adiciona")
	public ModelAndView adiciona() {
		ModelAndView view = new ModelAndView("views/sedes/adiciona");
		view.addObject(new Sede());
		return view;
	}
	
	@PostMapping("/sedes/adiciona")
	public String adiciona(Sede sede) {
		this.sedesService.salvar(sede);
		return "redirect:/sedes";
	}
	
	@GetMapping("/sedes/exibe/{id}")
	public ModelAndView exibe(@PathVariable("id") long id) {
		Sede sede = sedesService.findById(id);
		ModelAndView view = new ModelAndView("views/sedes/exibe");
		view.addObject("sede", sede);
		return view;
	}
}
