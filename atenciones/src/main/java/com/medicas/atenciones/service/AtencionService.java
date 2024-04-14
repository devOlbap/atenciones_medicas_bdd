package com.medicas.atenciones.service;

import com.medicas.atenciones.model.Atencion;

import java.util.List;


public interface AtencionService {
    List<Atencion> getAtenciones();
    Atencion getAtencionById(Long id);

    Atencion createAtencion(Atencion Atencion);
    Atencion updateAtencion(Long id, Atencion Atencion);

    Boolean deleteAtencion(Long id);
}

