package br.com.abutres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abutres.model.Estado;
import br.com.abutres.repository.Estados;

@Service
public class EstadosService {
	
	@Autowired
	private Estados estados;

	public void salvar(Estado estado) {
		estados.save(estado);
	}

	public void remover(Long id) {
		estados.deleteById(id);
	}
	
	public List<Estado> listaTodos() {
		return estados.findAll();
	}
	
	public Estado buscaPorId(long id) {
		return estados.getOne(id);
	}
}
