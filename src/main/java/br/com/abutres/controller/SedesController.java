package br.com.abutres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.abutres.model.Sede;
import br.com.abutres.repository.SedesRepository;

@Controller
@RequestMapping("/sedes")
public class SedesController {
	
	@Autowired
	private SedesRepository sedes;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("ListaSedes");
		view.addObject("sedes", sedes.findAll());
		view.addObject(new Sede());
		return view;
	}
	
	@PostMapping
	public String salvar(Sede sede) {
		this.sedes.save(sede);
		return "redirect:/sedes";

	}

}
