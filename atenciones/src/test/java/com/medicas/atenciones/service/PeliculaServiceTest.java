package com.medicas.atenciones.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.medicas.atenciones.model.Paciente;
import com.medicas.atenciones.repository.PacienteRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {

    @InjectMocks
    private PacienteServiceImpl pacienteServiceImpl;

    @Mock
    private PacienteRepository pacienteRepositoryMock;

    @Test
    public void guardarPacienteTest(){
        Paciente paciente = new Paciente();
        
        paciente.setId(null);
        paciente.setNombre("Gabriel");
        paciente.setApellido("Garrido");
        paciente.setRut(19034476);
        paciente.setDv("2");
        paciente.setDireccion("El manzano");
        paciente.setNumeracion("123123");

        when(pacienteRepositoryMock.save(any())).thenReturn(paciente);

        Paciente pac_res = pacienteServiceImpl.createPaciente(paciente);

        assertEquals("Gabriel", pac_res.getNombre());

    }


}
