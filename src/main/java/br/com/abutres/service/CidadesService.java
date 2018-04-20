package br.com.abutres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abutres.model.Cidade;
import br.com.abutres.repository.Cidades;

@Service
public class CidadesService {

	@Autowired
	private Cidades cidades;
	
	public void salvar(Cidade cidade) {
		cidades.save(cidade);
	}
	
	public void remover(Long id) {
		cidades.deleteById(id);
	}
	
	public List<Cidade> listaTodos() {
		return cidades.findAll();
	}
	
	public Cidade buscaPorId(long id) {
		return cidades.getOne(id);
	}
}
