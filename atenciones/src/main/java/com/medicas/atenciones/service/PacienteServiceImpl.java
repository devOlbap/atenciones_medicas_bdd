package com.medicas.atenciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicas.atenciones.model.Paciente;
import com.medicas.atenciones.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getPacientes(){
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente getPacienteById(Long id){
        Optional<Paciente> PacienteOP = pacienteRepository.findById(id);
        if (PacienteOP.isPresent()) {
            return PacienteOP.get(); 
        } else {
            return null; 
        }
    }
    @Override
    public Paciente createPaciente(Paciente Paciente){
        return pacienteRepository.save(Paciente);
    }
    @Override
    public Paciente updatePaciente(Long id, Paciente Paciente){

        if(pacienteRepository.existsById(id)){
            Paciente.setId(id);
            return pacienteRepository.save(Paciente);
        }
        return null;
    }
    @Override
    public Boolean deletePaciente(Long id){
        if(pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Paciente getPacienteByRut(int rut){
        Optional<Paciente> pacOpt = Optional.ofNullable(pacienteRepository.findByRut(rut));

        if (pacOpt.isPresent()) {
            return pacOpt.get(); 
        } else {
            return null; 
        }
    }



}
