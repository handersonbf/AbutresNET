package br.com.abutres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abutres.model.Usuario;
import br.com.abutres.repository.Usuarios;


@Service
public class UsuariosService {
	
	@Autowired
	private Usuarios usuarios;

	public void salvar(Usuario usuario) {
		usuarios.save(usuario);
	}

	public void remover(Long id) {
		usuarios.deleteById(id);
	}
	
	public List<Usuario> listaTodos() {
		return usuarios.findAll();
	}
	
	public Usuario buscaPorId(long id) {
		return usuarios.getOne(id);
	}
}
