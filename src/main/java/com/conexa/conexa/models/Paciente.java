package com.conexa.conexa.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Id
	  private Integer id;
	  
	  private String nome;

	  private String cpf;
	  
	  @OneToMany(mappedBy= "paciente")
	  private Set<Atendimento> atendimentos;
	  
	  public Integer getId() {
		return id;
	}

	public Paciente() {
		super();
	}

	public Paciente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
