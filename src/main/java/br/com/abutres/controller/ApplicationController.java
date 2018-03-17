package br.com.abutres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ApplicationController {

	@GetMapping
	@ResponseBody
	public String index() {
		return "AbutresNet";
	}
}
