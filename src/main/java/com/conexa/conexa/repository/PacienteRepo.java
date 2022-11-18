package com.conexa.conexa.repository;

import org.springframework.data.repository.CrudRepository;

import com.conexa.conexa.models.Medico;
import com.conexa.conexa.models.Paciente;

public interface PacienteRepo extends CrudRepository<Paciente, Integer> {

	Paciente findBycpf(String cpf);
	
}
