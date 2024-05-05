package com.medicas.atenciones.repository;

import com.medicas.atenciones.model.Medico;

import org.springframework.data.jpa.repository.JpaRepository;



public interface  MedicoRepository extends JpaRepository<Medico,Long>{

    Medico findByNombre(String nombre);
}
