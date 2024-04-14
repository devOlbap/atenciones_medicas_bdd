package com.medicas.atenciones.repository;

import com.medicas.atenciones.model.Atencion;

import org.springframework.data.jpa.repository.JpaRepository;


public interface  AtencionRepository extends JpaRepository<Atencion,Long>{
}
