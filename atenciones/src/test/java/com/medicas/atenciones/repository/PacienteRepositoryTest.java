package com.medicas.atenciones.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.medicas.atenciones.model.Paciente;
import com.medicas.atenciones.repository.PacienteRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {
    @Autowired
    private PacienteRepository pacienteRepository;


    @Test
    public void guardarPeliculaTest(){
        Paciente n_paciente = new Paciente();
        n_paciente.setNombre("Gabriel");

        Paciente res_paciente = pacienteRepository.save(n_paciente);

        assertNotNull(res_paciente.getId());
        assertEquals("Gabriel", res_paciente.getNombre());

    }


}
