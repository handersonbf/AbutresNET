package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

}
