package br.com.abutres.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "membro_punicoes")
public class MembroPunicoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_membro_punicoes")
	@SequenceGenerator(name="seq_membro_punicoes", sequenceName="seq_membro_punicoes",allocationSize=1)
	private Long id;
	
	@ManyToOne
	private Membro membro;

}
