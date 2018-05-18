package br.com.abutres.controller;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abutres.model.Sede;
import br.com.abutres.service.SedesService;

@Controller
@RequestMapping("/sedes")
public class SedesController {
	
	@Autowired
	private SedesService sedesService;
	
	@GetMapping
	public String listar(ModelMap model) {
		model.addAttribute("sedes", sedesService.findAll());
		return "views/sedes/listar";
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView adicionarCad(Sede sede) {
		ModelAndView mv = new ModelAndView("views/sedes/adicionar");
		
		mv.addObject(sede);
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public String adicionar(Sede sede, RedirectAttributes att) {
		sedesService.salvar(sede);
		att.addFlashAttribute("msg_sucess", "Operação realizada com sucesso!");

		return "redirect:/sedes/cadastrar";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Long id, ModelMap model) {
		sedesService.remover(id);
		model.addAttribute("msg_sucess", "Operação realizada com sucesso.");
		return listar(model);
	}
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionarCad(sedesService.findById(id));
	}


	@GetMapping("/sedes/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Sede sede = sedesService.findById(id);
		ModelAndView view = new ModelAndView("views/sedes/exibir");
		view.addObject("sede", sede);
		return view;
	}
}
