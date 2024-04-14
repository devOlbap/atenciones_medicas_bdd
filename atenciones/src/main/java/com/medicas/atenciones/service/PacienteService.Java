package com.medicas.atenciones.service;

import com.medicas.atenciones.model.Paciente;

import java.util.List;


public interface PacienteService {
    List<Paciente> getPacientes();
    Paciente getPacienteById(Long id);
    Paciente getPacienteByRut(int rut);

    Paciente createPaciente(Paciente paciente);
    Paciente updatePaciente(Long id, Paciente paciente);

    Boolean deletePaciente(Long id);
}

