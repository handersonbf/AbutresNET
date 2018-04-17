package br.com.abutres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abutres.model.Cidade;
import br.com.abutres.service.CidadesService;

@Controller
public class CidadesController {

	@Autowired
	private CidadesService cidades;

	@GetMapping("/cidades")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("views/cidades/listar");
		mv.addObject("cidades", cidades.listaTodos());
		return mv;
	}

	@GetMapping("/cidades/adicionar")
	public ModelAndView adicionar(Cidade cidade) {
		ModelAndView view = new ModelAndView("views/cidades/adicionar");
		return view;
	}

	@PostMapping("/cidades/adicionar")
	public ModelAndView adicionar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/cidades/adicionar");
		if (result.hasErrors()) {
			attributes.addFlashAttribute("msg_error", "Verifique os erros.");
			return mv;
		}
		this.cidades.salvar(cidade);

		attributes.addFlashAttribute("msg_sucess", "Cidade salvo com sucesso.");
		return new ModelAndView("redirect:/cidades");

	}

	@GetMapping("/cidades/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") long id) {
		Cidade cidade = cidades.buscaPorId(id);
		ModelAndView mv = new ModelAndView("views/cidades/exibir");
		mv.addObject("cidade", cidade);
		return mv;
	}

	@GetMapping("/cidades/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Cidade cidade = cidades.buscaPorId(id);
		ModelAndView view = new ModelAndView("views/cidades/editar");
		view.addObject("cidade", cidade);
		return view;
	}

	@PostMapping("/cidades/editar")
	public ModelAndView editar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/cidades/editar/"+cidade.getId());
		/*if (result.hasErrors()) {
			attributes.addFlashAttribute("msg_error", "Verifique os erros.");
			return mv;
		}
		this.cidades.salvar(cidade);

		attributes.addFlashAttribute("msg_sucess", "Cidade salvo com sucesso.");*/
		//mv = new ModelAndView("redirect:/cidades");
		return mv;

	}

	@PostMapping("/cidades/remover")
	public ModelAndView remover(long id) {
		cidades.remover(id);
		return new ModelAndView("redirect:/cidades/");
	}

}
