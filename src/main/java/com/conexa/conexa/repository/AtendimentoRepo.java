package com.conexa.conexa.repository;

import org.springframework.data.repository.CrudRepository;

import com.conexa.conexa.models.Atendimento;
import com.conexa.conexa.models.Medico;

public interface AtendimentoRepo extends CrudRepository<Atendimento, Integer> {

}
