package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Sede;

public interface SedesRepository extends JpaRepository<Sede, Long> {
	
}
