package com.medicas.atenciones.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.web.servlet.MockMvc;
import com.medicas.atenciones.model.Paciente;
import com.medicas.atenciones.service.PacienteService;


@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {

    //@Autowired
    //private PeliculaService peliculaService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService peliculaServiceMock;

    @Test
    public void obtenerPeliculasTest() throws Exception{

        // Paciente nueva_pelicula_1 = new Paciente();
        // nueva_pelicula_1.setId(1L);


        // Paciente nueva_pelicula_2 = new Paciente();
        // nueva_pelicula_2.setId(2L);
 

        // List<Paciente> peliculas_list = List.of(nueva_pelicula_1,nueva_pelicula_2);

        // List<EntityModel<Paciente>> peliculas_resources = peliculas_list.stream()
        //     .map(pelicula -> EntityModel.of(pelicula))
        //     .collect(Collectors.toList());

        // when(peliculaServiceMock.getPeliculas()).thenReturn(peliculas_list);


        // // peliculas_list = peliculas_resources.stream()
        // //     .map(entityModel -> entityModel.getContent())
        // //     .collect(Collectors.toList());

        // // when(peliculaServiceMock.getPeliculas()).thenReturn(peliculas_list);


        // mockMvc.perform(get("/pacientes"))
        //     //.andDo(print())
        //     .andExpect(status().isOk())
        //     .andExpect(jsonPath("$.length()").value(2))
        //     .andExpect(jsonPath("$.[0].titulo").value("Mi pobre angelito"))
        //     .andExpect(jsonPath("$.[1].titulo").value("Mi pobre angelito2"))

        // //    .andExpect(jsonPath("$._embedded.peliculas_list.length()").value(2))
        // //    .andExpect(jsonPath("$._embedded.peliculas_list[0].titulo").value("Mi pobre angelito"))
        // //    .andExpect(jsonPath("$._embedded.peliculas_list[1].titulo").value("Mi pobre angelito2"))
        // ;
    }

    
    
}
