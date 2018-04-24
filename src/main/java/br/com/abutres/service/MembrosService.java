package br.com.abutres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abutres.model.Membro;
import br.com.abutres.repository.Membros;

@Service
public class MembrosService {

	@Autowired
	private Membros membros;
	
	public void salvar(Membro membro) {
		membros.save(membro);
	}
	
	public void remover(Long id) {
		membros.deleteById(id);
	}
	
	public List<Membro> listaTodos() {
		return membros.findAll();
	}
	
	public Membro buscaPorId(long id) {
		return membros.getOne(id);
	}
}
