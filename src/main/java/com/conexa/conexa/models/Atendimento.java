package com.conexa.conexa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="atendimento")
public class Atendimento {

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	  
	  private String dataHora;
	  
	  @ManyToOne
	  @JoinColumn(name="medico_id", nullable=false)
	  private Medico medicoResponsavel;
	  

	  @ManyToOne
	  @JoinColumn(name="paciente_cpf", nullable=false)
	public Paciente paciente;
	  	
	  public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public Atendimento(Medico medicoResponsavel, Paciente paciente) {
		super();
		this.medicoResponsavel = medicoResponsavel;
		this.paciente = paciente;
	}
}
