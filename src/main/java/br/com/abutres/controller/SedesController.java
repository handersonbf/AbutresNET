package br.com.abutres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@GetMapping("/sedes")
	public String listar(ModelMap model) {
		model.addAttribute("sedes", sedesService.findAll());
		return "views/sedes/listar";
	}
	
	@GetMapping("/sedes/cadastrar")
	public String adicionar(Sede sede) {
		return "views/sedes/adicionar";
	}
	
	@PostMapping("/sedes/salvar")
	public String adicionar(Sede sede, RedirectAttributes att) {
		sedesService.salvar(sede);
		att.addFlashAttribute("msg_sucess", "Sede inserida com sucesso!");

		return "redirect:/sedes/cadastrar";
	}
	
	@GetMapping("/sedes/remover/{id}")
	public String remover(@PathVariable("id") Long id, ModelMap model) {
		sedesService.remover(id);
		model.addAttribute("msg_sucess", "Sede removida com sucesso.");
		return listar(model);
	}
	
	
	//deixando o editar
	@GetMapping("/sedes/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("sede", sedesService.findById(id));
		return "/views/sedes/adicionar";
	}
	@PostMapping("/sedes/editar")
	public String editar(Sede sede, RedirectAttributes att) {
		att.addFlashAttribute("msg_sucess", "Sede editada com sucesso.");
		return "redirect:/sedes/listar";
	}
	

	@GetMapping("/sedes/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Sede sede = sedesService.findById(id);
		ModelAndView view = new ModelAndView("views/sedes/exibir");
		view.addObject("sede", sede);
		return view;
	}
}
