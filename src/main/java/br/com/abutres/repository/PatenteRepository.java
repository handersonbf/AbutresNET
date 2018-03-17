package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Patente;

public interface PatenteRepository extends JpaRepository<Patente, Long> {

}
