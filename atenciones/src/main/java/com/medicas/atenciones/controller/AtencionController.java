package com.medicas.atenciones.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicas.atenciones.model.Atencion;
import com.medicas.atenciones.model.Medico;
import com.medicas.atenciones.model.Paciente;

import com.medicas.atenciones.model.AtencionResponse;

import com.medicas.atenciones.service.AtencionService;
import com.medicas.atenciones.service.MedicoService;
import com.medicas.atenciones.service.PacienteService;

import java.util.ArrayList;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/atencion")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Atencion> getAtenciones(){
        return atencionService.getAtenciones();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAtencionById(@PathVariable Long id) {
        /*
         * ESTADOS = {
         *      'Cancelado' = 'C',
         *      'Pendiente' = 'P',
         *      'Historial' = 'H',
         * }
        */
        List<String> errores = new ArrayList<>();

        Atencion at = atencionService.getAtencionById(id);
        if(at == null){
            errores.add("No existe atencion con id: "+id);
            return ResponseEntity.badRequest().body(errores);
        }

        Medico medico = medicoService.getMedicoById(at.getIdMedico());

        Paciente paciente = pacienteService.getPacienteById(at.getIdPaciente());

        System.out.println(at.getEstado());

        String est_at = at.getEstado().equals("C") ? "Cancelado" : 
                (at.getEstado().equals("P") ? "Pendiente" : "Historial");

        AtencionResponse at_response = new AtencionResponse(
            at.getId(),
            medico.getFullName(),
            paciente.getFullName(),
            at.getFecha(),
            est_at
        );

        return ResponseEntity.ok(at_response);
    }
    
     @PostMapping("/add")
    public ResponseEntity<?> createAtencion(@RequestBody Atencion atencion) {
        List<String> errores = new ArrayList<>();

        Medico medico = medicoService.getMedicoById(atencion.getIdMedico());

        if(medico == null){
            errores.add("Error: no se encontró medico con el id:"+atencion.getIdMedico());
            return ResponseEntity.badRequest().body(errores);
        }

        Paciente paciente = pacienteService.getPacienteById(atencion.getIdPaciente());
        if(paciente == null){
            errores.add("Error: no se encontró paciente con el id: "+atencion.getIdPaciente());
            return ResponseEntity.badRequest().body(errores);
        }


        return ResponseEntity.ok(atencionService.createAtencion(atencion));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAtencion(@PathVariable Long id, @RequestBody Atencion atencion) {
        /*
         * Al igual que el POST tenemos que validar que los datos sean correctos
         * como la fecha, id_medico, id_paciente
         * tenemos que ver el estado tambien en este apartado.. 
         * que pasa si solo se quiere modificar el estado? 
         * ESTADOS = {
         *      'Cancelado' = 'C',
         *      'Pendiente' = 'P',
         *      'Historial' = 'H',
         * }
        */
        List<String> errores = new ArrayList<>();
        
        Medico medico = medicoService.getMedicoById(atencion.getIdMedico());

        if(medico == null){
            errores.add("Error al buscar el medico con id: "+atencion.getIdMedico());
            return ResponseEntity.badRequest().body(errores);
        }

        Paciente paciente = pacienteService.getPacienteById(atencion.getIdPaciente());

        if(paciente == null){
            errores.add("Error al buscar el paciente con id: "+atencion.getIdPaciente());
        }

        String auxFecha = atencion.getFecha();
        if(auxFecha.trim().length() < 10 || auxFecha.trim().length() > 10 ){
            errores.add("Debe ingresar una fecha válida.(formato '14-04-2024' -> 'dd-mm-yyyy')");
            ResponseEntity.badRequest().body(errores);
        } 

        atencion.setIdMedico(medico.getId());
        atencion.setIdPaciente(paciente.getId());

        if( auxFecha.trim().length() == 10){
            return ResponseEntity.ok(atencionService.updateAtencion(id, atencion));
        }
        errores.add("Error en la petición.");
        return ResponseEntity.badRequest().body(errores);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delAtencion(@PathVariable Long id) {
        /*
         * Aqui podriamos solo desactivar y no eliminar... 
         * asi cambiamos el estado a 'H'
         * ... y el update es para la fecha.
         *  
         * ESTADOS ={
         *      Cancelado => 'C',
         *      Pendiente => 'P',
         *      Historial => 'H',
         * }
         * 
        */
        List<String> mensajes = new ArrayList<>();
        Atencion atencion = atencionService.getAtencionById(id);

        if(atencion == null){
            mensajes.add("Error al buscar el registro con id: "+id);
            return ResponseEntity.badRequest().body(mensajes);
        }

        if(atencion.getEstado().equals("C")){
            mensajes.add("Atención con fecha: "+atencion.getFecha()+". Ya figura como Cancelada.");
            return ResponseEntity.badRequest().body(mensajes);
        }

        atencion.setEstado("C");

        /*
         * Tuvimos que formatear la fecha que ya tenia la Atención.
         */
        String fechaRecibida = atencion.getFecha();
        LocalDateTime fecha = LocalDateTime.parse(fechaRecibida, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fecha.format(formatter);

        atencion.setFecha(fechaFormateada);

        Atencion new_at = atencionService.updateAtencion(id, atencion);

        mensajes.add("Atencion con fecha: "+new_at.getFecha()+". Ha sido Cancelada.");

        return ResponseEntity.ok(mensajes);

    }


}