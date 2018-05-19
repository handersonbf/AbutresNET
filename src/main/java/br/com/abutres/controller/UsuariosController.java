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

import br.com.abutres.model.Usuario;
import br.com.abutres.service.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuarios;
		
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/listar");
		modelAndView.addObject("usuarios", usuarios.listaTodos());
		return modelAndView;
	}	

	@GetMapping("/adicionar")
	public ModelAndView adicionar(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("views/usuario/adicionar");
		modelAndView.addObject(usuario);
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return adicionar(usuario);
		}
		this.usuarios.salvar(usuario);			
		attributes.addFlashAttribute("msg_sucess", "Operação realizada com sucesso.");
		return new ModelAndView("redirect:/usuarios/");
	}
		
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return adicionar(usuarios.buscaPorId(id));
	}	
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		usuarios.remover(id);	
		attributes.addFlashAttribute("msg_sucess", "Operação realizada com sucesso.");
		return "redirect:/usuarios";
	}	
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Usuario user = usuarios.buscaPorId(id);
		ModelAndView modelAndView = new ModelAndView("views/usuarios/exibir");
		modelAndView.addObject("usuario", user);
		return modelAndView;
	}	
}
