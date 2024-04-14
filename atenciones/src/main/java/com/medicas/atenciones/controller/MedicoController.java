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

import com.medicas.atenciones.model.Medico;
import com.medicas.atenciones.service.MedicoService;

import java.util.HashMap;
import java.util.Map;

import java.util.List;


@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> getPacientes(){
        return medicoService.getMedicos();
    }
    @GetMapping("/{id}")
    public Medico getMedicoById(@PathVariable Long id) {
        return medicoService.getMedicoById(id);
    }
    
     @PostMapping("/add")
    public ResponseEntity<?> createMedico(@RequestBody Medico medico) {
        //Lista de errores en validaciones
        List<String> errores = medico.validarCampos();

        if (!errores.isEmpty()) {
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(medicoService.createMedico(medico));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedico(@PathVariable Long id, @RequestBody Medico medico) {

        List<String> errores = medico.validarCampos();

        if (!errores.isEmpty()) {
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.ok(medicoService.updateMedico(id, medico));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delMedico(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();

        Medico medico = medicoService.getMedicoById(id);

        if(medicoService.deleteMedico(id)){
            response.put("mensaje", "Medico eliminado exitosamente con ID: " + id+" Nombre: "+medico.getFullName());
            return ResponseEntity.ok().body(response);
        }
        response.put("mensaje", "No existe registro con el ID:"+id);
        return ResponseEntity.badRequest().body(response);
    }


}