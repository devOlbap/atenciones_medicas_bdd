package com.medicas.atenciones.service;

import com.medicas.atenciones.model.Medico;

import java.util.List;


public interface MedicoService {
    List<Medico> getMedicos();
    Medico getMedicoById(Long id);

    Medico createMedico(Medico Medico);
    Medico updateMedico(Long id, Medico Medico);

    Boolean deleteMedico(Long id);
}

