package br.com.abutres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abutres.model.Sede;
import br.com.abutres.repository.Sedes;

@Service
public class SedesService {

	@Autowired
	private Sedes sedes;

	public void salvar(Sede sede) {
		sedes.save(sede);
	}

	public void remover(Long id) {
		sedes.deleteById(id);
	}
	
	public List<Sede> findAll() {
		return sedes.findAll();
	}
	
	public Sede findById(long id) {
		return sedes.getOne(id);
	}
}
