package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

}
