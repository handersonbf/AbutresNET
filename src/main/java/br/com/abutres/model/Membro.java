package br.com.abutres.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
@SequenceGenerator(name="seq_membro", sequenceName="seq_membro", initialValue=1, allocationSize=1)
public class Membro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_membro")	
	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String apelido;
	
	@Size(min=10,max=10)
	private String telefone;
	
	@Email
	private String email;
		
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	@Column(name="data_admissao")
	private Date dataAdmissao;
	
	@NumberFormat
	private String cnh;

	private String veiculo;
	
	private String endereco;

	private String motoClubeItens;
	private String patente;	
	private String sede;
	private String advertencias;
	private String punicoes;
	private String foto;
	private String status;
	
	
	
	
	
	
	
	
public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMotoClubeItens() {
		return motoClubeItens;
	}

	public void setMotoClubeItens(String motoClubeItens) {
		this.motoClubeItens = motoClubeItens;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getAdvertencias() {
		return advertencias;
	}

	public void setAdvertencias(String advertencias) {
		this.advertencias = advertencias;
	}

	public String getPunicoes() {
		return punicoes;
	}

	public void setPunicoes(String punicoes) {
		this.punicoes = punicoes;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*	@OneToOne
	@JoinColumn(name="patente_id")
	private Patente patente;
	
	private String cnh;
	
	@OneToMany
	@JoinTable(
			name="membro_has_moto_clube_itens",
			joinColumns= {
					@JoinColumn(name="membro_id", referencedColumnName="id")
			},
			inverseJoinColumns= {
					@JoinColumn(name="moto_clube_item_id", referencedColumnName="id")
			}
	)
	private List<MotoClubeItem> motoClubeItens;
	
	
	
	@OneToMany
	@JoinTable(
			name="membro_has_membro_advertencias",
			joinColumns= {
					@JoinColumn(name="membro_id", referencedColumnName="id")
			},
			inverseJoinColumns= {
					@JoinColumn(name="membro_advertencias_id", referencedColumnName="id")
			}
	)
	private List<MembroAdvertencia> membroAdvertencias;
	
	@OneToMany(cascade= {CascadeType.REMOVE})
	@JoinTable(
			name="membro_has_membro_punicoes",
			joinColumns= {
					@JoinColumn(name="membro_id", referencedColumnName="id")
			},
			inverseJoinColumns= {
					@JoinColumn(name="membro_punicoes_id", referencedColumnName="id")
			}
	)
	private List<MembroPunicoes> membroPunicoes;
	
	private String foto;
	
	@Enumerated(EnumType.STRING)
	private Status status;
*/
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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
