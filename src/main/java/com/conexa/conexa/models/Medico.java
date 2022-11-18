package com.conexa.conexa.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="medico")
public class Medico {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  private String senha;
  
  public Medico(String senha, String especialidade, String cpf, String dataNascimento, String telefone, String email) {
	super();
	this.senha = senha;
	this.especialidade = especialidade;
	this.cpf = cpf;
	this.dataNascimento = dataNascimento;
	this.telefone = telefone;
	this.email = email;
}

private String especialidade;
  
  private String cpf;
  
  private String dataNascimento;
  
  private String telefone;  

  private String email;
  
  @OneToMany(mappedBy= "medicoResponsavel")
  private Set<Atendimento> atendimentos;
  
  public Medico(Medico medico) {
}

public Medico() {
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getEspecialidade() {
	return especialidade;
}

public void setEspecialidade(String especialidade) {
	this.especialidade = especialidade;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getDataNascimento() {
	return dataNascimento;
}

public void setDataNascimento(String dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}