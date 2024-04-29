package com.medicas.atenciones.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.medicas.atenciones.model.Atencion;
import com.medicas.atenciones.repository.AtencionRepository;

@ExtendWith(MockitoExtension.class)
public class AtencionServiceTest {

    @InjectMocks
    private AtencionServiceImpl atencionServiceImpl;

    @Mock
    private AtencionRepository atencionRepositoryMock;

    @Test
    public void guardarAtencionTest(){
        Atencion atencion = new Atencion();
        
        atencion.setId((long)12);
        atencion.setEstado("P");
        atencion.setFecha("02-04-2024");
        atencion.setIdMedico((long)4);
        atencion.setIdPaciente((long)2);

        when(atencionRepositoryMock.save(any())).thenReturn(atencion);

        Atencion atencion_res = atencionServiceImpl.createAtencion(atencion);

        assertEquals(2, atencion_res.getIdPaciente());

    }


}
