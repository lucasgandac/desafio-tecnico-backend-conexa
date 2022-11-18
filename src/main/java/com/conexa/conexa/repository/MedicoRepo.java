package com.conexa.conexa.repository;

import org.springframework.data.repository.CrudRepository;

import com.conexa.conexa.models.Medico;

public interface MedicoRepo extends CrudRepository<Medico, Integer> {
	Medico findByemail(String username);
}
