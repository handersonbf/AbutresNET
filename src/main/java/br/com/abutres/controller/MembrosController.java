package br.com.abutres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abutres.model.Membro;
import br.com.abutres.service.MembrosService;

@Controller
@RequestMapping("/membros")
public class MembrosController {
	
	@Autowired
	private MembrosService membros;
		
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("views/membros/listar");
		modelAndView.addObject("membros", membros.listaTodos());
		return modelAndView;
	}	

	@GetMapping("/adicionar")
	public ModelAndView adicionar(Membro membro) {
		ModelAndView modelAndView = new ModelAndView("views/membros/adicionar");
		modelAndView.addObject(membro);
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Membro membro, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return adicionar(membro);
		}
		this.membros.salvar(membro);			
		attributes.addFlashAttribute("msg_sucess", "Membro salvo com sucesso.");
		return new ModelAndView("redirect:/membros/");
	}
		
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionar(membros.buscaPorId(id));
	}	
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		membros.remover(id);	
		attributes.addFlashAttribute("msg_sucess", "Membro removido com sucesso.");
		return "redirect:/membros";
	}	
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Membro membro = membros.buscaPorId(id);
		ModelAndView modelAndView = new ModelAndView("views/membros/exibir");
		modelAndView.addObject("membro", membro);
		return modelAndView;
	}	
}
