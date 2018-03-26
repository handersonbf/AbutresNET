package br.com.abutres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.abutres.model.Sede;
import br.com.abutres.service.SedesService;

@Controller
public class SedesController {
	
	@Autowired
	private SedesService sedesService;
	
	
	@GetMapping("/sedes")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("views/sedes/lista");
		view.addObject("sedes", sedesService.findAll());
		view.addObject(new Sede());
		return view;
	}
	
	@PostMapping("/sedes")
	public String salvar(Sede sede) {
		this.sedesService.salvar(sede);
		return "redirect:/sedes";
	}
}
