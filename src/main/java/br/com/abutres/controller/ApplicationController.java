package br.com.abutres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping(value={"", "/", "configuracoes", "ajuda"})
	public String index() {
		return "index";
	}
}
