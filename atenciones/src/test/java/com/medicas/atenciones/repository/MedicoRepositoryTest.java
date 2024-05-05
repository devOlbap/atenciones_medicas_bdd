package com.medicas.atenciones.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.medicas.atenciones.model.Medico;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MedicoRepositoryTest {

    @Mock
    private MedicoRepository medicoRepository;

    @Test
    public void obtenerMedicoByNombreTest() {

        Medico medico = new Medico();
        medico.setId(null);
        medico.setNombre("Gabriel");
        medico.setApellido("Garrido");
        medico.setProfesion("Neurologo");

        // Configurar el comportamiento esperado del repositorio mock
        when(medicoRepository.findByNombre("Gabriel")).thenReturn(medico);

        // Llamar al método que queremos probar
        Medico med_res = medicoRepository.findByNombre("Gabriel");

        // Verificar los resultados
        assertNotNull(med_res);
        assertEquals(med_res.getNombre(), "Gabriel");
    }
}
