package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Comunicado;

public interface ComunicadosRepository extends JpaRepository<Comunicado, Long> {

}
