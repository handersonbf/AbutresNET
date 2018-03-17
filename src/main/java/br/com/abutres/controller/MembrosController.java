package br.com.abutres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.abutres.repository.MembroRepository;

@Controller
@RequestMapping("/membros")
public class MembrosController {
	
	@Autowired
	private MembroRepository membros;
	
	@GetMapping
	public String index() {
		return "Teste";
	}
}
