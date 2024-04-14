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

import com.medicas.atenciones.model.Paciente;
import com.medicas.atenciones.service.PacienteService;

import java.util.HashMap;
import java.util.Map;

import java.util.List;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getUsers(){
        return pacienteService.getPacientes();
    }
    @GetMapping("/{id}")
    public Paciente getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }
    
     @PostMapping("/add")
    public ResponseEntity<?> createPaciente(@RequestBody Paciente paciente) {
        
        //Lista de errores en validaciones
        List<String> errores = paciente.validarCampos();

        if (!errores.isEmpty()) {
            return ResponseEntity.badRequest().body(errores);
        }

        //Si el rut es valido debemos preguntar si ya existe un registro con ese rut
        Paciente paciente_exists = pacienteService.getPacienteByRut(paciente.getRut());

        if(paciente_exists!=null){
            if(paciente_exists.getDv().equals(paciente.getDv())){
                errores.add("Paciente ya existe con RUT:"+paciente_exists.getFullRUT());            
                return ResponseEntity.badRequest().body(errores);
            }
            errores.add("Paciente ya existe con RUT:"+paciente_exists.getRut());            
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(pacienteService.createPaciente(paciente));
        

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {

        List<String> errores = paciente.validarCampos();

        if (!errores.isEmpty()) {
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.ok(pacienteService.updatePaciente(id, paciente));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delPaciente(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();

        Paciente paciente = pacienteService.getPacienteById(id);

        if(pacienteService.deletePaciente(id)){
            response.put("mensaje", "Paciente eliminado exitosamente con ID: " + id+" Nombre: "+paciente.getFullName());
            return ResponseEntity.ok().body(response);
        }
        response.put("mensaje", "No existe registro con el ID:"+id);
        return ResponseEntity.badRequest().body(response);
    }


}