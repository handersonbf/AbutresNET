package br.com.abutres.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Sede implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_sede", sequenceName = "seq_sede", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sede")
	private Long id;
	
	private String fotoLogoSede;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	
	private String nome;
	
	private Membro diretor;
	
	private Membro subDiretor;
	
	private Endereco endereco;
	
	private String telefone;
	
	private Sede sedeMae;

	public Sede() {

	}

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

	public Membro getDiretor() {
		return diretor;
	}

	public void setDiretor(Membro diretor) {
		this.diretor = diretor;
	}

	public Membro getSubDiretor() {
		return subDiretor;
	}

	public void setSubDiretor(Membro subDiretor) {
		this.subDiretor = subDiretor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Sede getSedeMae() {
		return sedeMae;
	}

	public void setSedeMae(Sede sedeMae) {
		this.sedeMae = sedeMae;
	}

	public String getFotoLogoSede() {
		return fotoLogoSede;
	}

	public void setFotoLogoSede(String fotoLogoSede) {
		this.fotoLogoSede = fotoLogoSede;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFundacao == null) ? 0 : dataFundacao.hashCode());
		result = prime * result + ((diretor == null) ? 0 : diretor.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((fotoLogoSede == null) ? 0 : fotoLogoSede.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sedeMae == null) ? 0 : sedeMae.hashCode());
		result = prime * result + ((subDiretor == null) ? 0 : subDiretor.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sede other = (Sede) obj;
		if (dataFundacao == null) {
			if (other.dataFundacao != null)
				return false;
		} else if (!dataFundacao.equals(other.dataFundacao))
			return false;
		if (diretor == null) {
			if (other.diretor != null)
				return false;
		} else if (!diretor.equals(other.diretor))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (fotoLogoSede == null) {
			if (other.fotoLogoSede != null)
				return false;
		} else if (!fotoLogoSede.equals(other.fotoLogoSede))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sedeMae == null) {
			if (other.sedeMae != null)
				return false;
		} else if (!sedeMae.equals(other.sedeMae))
			return false;
		if (subDiretor == null) {
			if (other.subDiretor != null)
				return false;
		} else if (!subDiretor.equals(other.subDiretor))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
