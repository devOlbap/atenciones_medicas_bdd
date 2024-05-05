

package com.medicas.atenciones.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.medicas.atenciones.model.Paciente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @Test
    public void obtenerPacienteByRutTest() {
        // Datos de prueba
        Paciente paciente = new Paciente();
        paciente.setId(null);
        paciente.setNombre("Gabriel");
        paciente.setApellido("Garrido");
        paciente.setRut(19034476);
        paciente.setDv("2");
        paciente.setDireccion("El manzano");
        paciente.setNumeracion("123123");

        // Configurar el comportamiento esperado del repositorio mock
        when(pacienteRepository.findByRut(19034476)).thenReturn(paciente);

        // Llamar al método que queremos probar
        Paciente pac_res = pacienteRepository.findByRut(19034476);

        // Verificar los resultados
        assertNotNull(pac_res);
        assertEquals(pac_res.getRut(), 19034476);
    }
}



