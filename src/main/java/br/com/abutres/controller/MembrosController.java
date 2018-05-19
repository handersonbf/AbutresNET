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

import br.com.abutres.model.Membro;
import br.com.abutres.model.Sede;
import br.com.abutres.service.MembrosService;
import br.com.abutres.service.SedesService;

@Controller
@RequestMapping("/membros")
public class MembrosController {
	
	@Autowired
	private MembrosService membrosService;
	
	@Autowired
	private SedesService sedeService;
		
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("views/membros/listar");
		modelAndView.addObject("membros", membrosService.listaTodos());
		return modelAndView;
	}	

	@GetMapping("/adicionar")
	public ModelAndView adicionar(Membro membro) {
		ModelAndView modelAndView = new ModelAndView("views/membros/adicionar");
		List<Sede> sedes = sedeService.findAll();
		modelAndView.addObject(sedes);
		modelAndView.addObject(membro);
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Membro membro, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return adicionar(membro);
		}
		this.membrosService.salvar(membro);			
		attributes.addFlashAttribute("msg_sucess", "Membro salvo com sucesso.");
		return new ModelAndView("redirect:/membros/");
	}
		
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionar(membrosService.buscaPorId(id));
	}	
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		membrosService.remover(id);	
		attributes.addFlashAttribute("msg_sucess", "Membro removido com sucesso.");
		return "redirect:/membros";
	}	
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Membro membro = membrosService.buscaPorId(id);
		ModelAndView modelAndView = new ModelAndView("views/membros/exibir");
		modelAndView.addObject("membro", membro);
		return modelAndView;
	}
	
	@ModelAttribute("sedes")
	public List<Sede> getSedes(){
		return sedeService.findAll();
	}
	
}
