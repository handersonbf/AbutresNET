package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Estado;

public interface EstadosRepository extends JpaRepository<Estado, Long> {

}
