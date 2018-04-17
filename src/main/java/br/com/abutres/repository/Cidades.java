package br.com.abutres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abutres.model.Cidade;

public interface Cidades extends JpaRepository<Cidade, Long> {

}
