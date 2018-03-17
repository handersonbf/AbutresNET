package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

}
