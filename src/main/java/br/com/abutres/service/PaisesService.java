package br.com.abutres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abutres.model.Pais;
import br.com.abutres.repository.Paises;

@Service
public class PaisesService {
	
	@Autowired
	private Paises paises;

	public void salvar(Pais pais) {
		paises.save(pais);
	}

	public void remover(Long id) {
		paises.deleteById(id);
	}
	
	public List<Pais> listaTodos() {
		return paises.findAll();
	}
	
	public Pais buscaPorId(long id) {
		return paises.getOne(id);
	}
}
