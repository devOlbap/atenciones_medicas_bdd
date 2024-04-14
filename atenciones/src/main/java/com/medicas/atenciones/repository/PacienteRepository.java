package com.medicas.atenciones.repository;

import com.medicas.atenciones.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface  PacienteRepository extends JpaRepository<Paciente,Long>{
    Paciente findByRut(int rut);
}
