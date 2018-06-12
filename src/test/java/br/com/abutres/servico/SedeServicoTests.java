package br.com.abutres.servico;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.abutres.model.Membro;
import br.com.abutres.service.MembrosService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SedeServicoTests {

	@Autowired
	MembrosService membrosService;
	
	public void teste() {
		
	}

	private Membro membro() {
		String nomeHanderson = "Handerson Frota";
		String apelidoHanderson = "Ogro";
		String telefoneHanderson = "9999999999";
		
		return new Membro(nomeHanderson, 
				apelidoHanderson, 
				telefoneHanderson,  
				new Date("10/09/2000"), 
				new Date("10/01/2018")); 
	}
	
}
