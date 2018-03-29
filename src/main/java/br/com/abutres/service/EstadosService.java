package br.com.abutres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abutres.model.Estado;
import br.com.abutres.repository.EstadosRepository;

@Service
public class EstadosService {
	
	@Autowired
	private EstadosRepository estados;

	public void salvar(Estado estado) {
		estados.save(estado);
	}

	public void remover(Long id) {
		estados.deleteById(id);
	}
	
	public List<Estado> findAll() {
		return estados.findAll();
	}
	
	public Estado findById(long id) {
		return estados.getOne(id);
	}
}
