package br.com.abutres.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sede implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String diretor;
	private String subDiretor;
	private String endereco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getSubDiretor() {
		return subDiretor;
	}
	public void setSubDiretor(String subDiretor) {
		this.subDiretor = subDiretor;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
