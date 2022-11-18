package com.conexa.conexa.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conexa.conexa.models.Atendimento;
import com.conexa.conexa.models.Medico;
import com.conexa.conexa.models.Paciente;
import com.conexa.conexa.repository.AtendimentoRepo;
import com.conexa.conexa.repository.MedicoRepo;
import com.conexa.conexa.repository.PacienteRepo;


@Controller 
@RequestMapping(path="/api/v1") 
public class MedicoController {
  @Autowired 
  private MedicoRepo medRepo;
  
  @Autowired 
  private AtendimentoRepo atendRepo;
  
  @Autowired 
  private PacienteRepo pacientRepo;

  @Autowired 
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @PostMapping(path="/signup", consumes = "application/json", produces = "application/json")
  public @ResponseBody Medico addMedico (@RequestBody Medico medico ) {

    //Medico med = new Medico();
	String email = medico.getEmail();
    String senha = bCryptPasswordEncoder.encode(medico.getSenha());
    String espec = medico.getEspecialidade();
    String cpf = medico.getCpf();
    String data = medico.getDataNascimento();
    String tel = medico.getDataNascimento();
    
	Medico med = new Medico(senha, espec, cpf, data, tel, email);
	
	return medRepo.save(med);
  }

  @GetMapping(path="/users")
  public @ResponseBody Iterable<Medico> getAllUsers() {
    return medRepo.findAll();
  }
  
  @PostMapping(path="/attendance", consumes = "application/json")
  public @ResponseBody Atendimento addMedico (@RequestBody Atendimento atend) {
	  Medico medd = new Medico();
	System.out.println(atend.paciente.getCpf());
    //medRepo.save(atend);
	Paciente pacExist = pacientRepo.findBycpf(atend.paciente.getCpf());
	if(pacExist != null) {
		Atendimento atd = new Atendimento(medd, pacExist);
		atd.setDataHora(atend.getDataHora());
		return atd;
	}else {
		Paciente pac = new Paciente(atend.paciente.getNome(), atend.paciente.getCpf());
		Atendimento atd = new Atendimento(medd, pac);
		atd.setDataHora(atend.getDataHora());
		return atd;
	}    
  }
  
  @GetMapping(path="/test")
  public @ResponseBody Iterable<Medico> test() {

	 Medico med = new Medico();
	 Paciente pat = new Paciente("JOrge", "666");
	 Atendimento atend  = new Atendimento(med, pat);
	 pacientRepo.save(pat);
	 medRepo.save(med);
	 atendRepo.save(atend);
    return medRepo.findAll();
  }
}