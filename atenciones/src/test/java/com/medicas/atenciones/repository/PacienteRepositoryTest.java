package com.medicas.atenciones.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.medicas.atenciones.model.Paciente;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {
    @Autowired
    private PacienteRepository pacienteRepository;


    @Test
    public void obtenerPacienteByRutTest(){

        Paciente pacientebyrut = pacienteRepository.findByRut(12345678);

        assertNotNull(pacientebyrut.getId());
        assertEquals(pacientebyrut.getRut(), 12345678);

    }


}
