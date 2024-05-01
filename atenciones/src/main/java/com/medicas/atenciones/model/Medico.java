package com.medicas.atenciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="MEDICO")
public class Medico {
    @Id
    @Column(
        nullable = false,
        name= "id"
    )
    private Long id;
    
    @Column(
        nullable = false,
        name= "nombre"
    )
    private String nombre;
    
    @Column(
        nullable = false,
        name= "apellido"
    )
    private String apellido;

    @Column(
        nullable = false,
        name= "profesion"
    )
    private String profesion;

    
    public Medico() {}

    public Medico(
            String nombre,
            String apellido,
            String profesion
            
        ) {
            this.nombre = nombre ;
            this.apellido = apellido ;
            this.profesion = profesion ;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<String> validarCampos() {
        List<String> mensajes = new ArrayList<>();
    
        if (!validarNombre()) {
            mensajes.add("El nombre debe tener entre 2 y 50 caracteres.");
        }
        if (!validarApellido()) {
            mensajes.add("El apellido debe tener entre 2 y 50 caracteres.");
        }
       
        if (!validarProfesion()) {
            mensajes.add("La profesion no puede estar vacía.");
        }
    
        return mensajes;
    }
    
    private boolean validarNombre() {
        return nombre != null && nombre.length() >= 2 && nombre.length() <= 100;
    }
    
    private boolean validarApellido() {
        return apellido != null && apellido.length() >= 2 && apellido.length() <= 100;
    }
    
    
    private boolean validarProfesion() {
        return profesion != null && !profesion.isEmpty() && profesion.length() <=100 && profesion.length() > 0 ;
    }
    
    public String getFullName() {
        return nombre + " " + apellido;
    }
    
}
