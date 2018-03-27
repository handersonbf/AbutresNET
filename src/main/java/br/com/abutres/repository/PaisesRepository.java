package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Pais;

public interface PaisesRepository extends JpaRepository<Pais, Long> {

}
