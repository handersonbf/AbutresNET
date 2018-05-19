package br.com.abutres.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String logradouro;

	private String bairro;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
