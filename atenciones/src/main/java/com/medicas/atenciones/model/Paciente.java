package com.medicas.atenciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="paciente")
public class Paciente {
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
        name= "rut"
    )
    private int rut;

    @Column(
        nullable = false,
        name= "dv"
    )
    private String dv;
    @Column(
        nullable = false,
        name= "direccion"
    )
    private String direccion;
    @Column(
        nullable = false,
        name= "numeracion"
    )
    private String numeracion;
    
    public Paciente() {}

    public Paciente(
            String nombre,
            String apellido,
            int rut,
            String dv,
            String direccion,
            String numeracion
        ) {
            this.nombre = nombre ;
            this.apellido = apellido ;
            this.rut = rut ;
            this.dv = dv ;
            this.direccion = direccion ;
            this.numeracion = numeracion ;
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

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public List<String> validarCampos() {
        List<String> mensajes = new ArrayList<>();
    
        if (!validarNombre()) {
            mensajes.add("El nombre debe tener entre 2 y 50 caracteres.");
        }
        if (!validarApellido()) {
            mensajes.add("El apellido debe tener entre 2 y 50 caracteres.");
        }
        if (!validarRut()) {
            mensajes.add("El RUT debe ser válido.");
        }
        if (!validarDv()) {
            mensajes.add("El dígito verificador (DV) del RUT debe ser válido.");
        }
        if (!validarDireccion()) {
            mensajes.add("La dirección no puede estar vacía.");
        }
        if (!validarNumeracion()) {
            mensajes.add("La numeración no puede estar vacía.");
        }
    
        return mensajes;
    }
    
    private boolean validarNombre() {
        return nombre != null && nombre.length() >= 2 && nombre.length() <= 100;
    }
    
    private boolean validarApellido() {
        return apellido != null && apellido.length() >= 2 && apellido.length() <= 100;
    }
    
    private boolean validarRut() {
        if(rut==0){
            return false;
        }
        String rutStr = String.valueOf(rut);
        return rutStr.length() >= 7 && rutStr.length() <= 8 ;
    }
    
    private boolean validarDv() {
        // Lógica de validación del dígito verificador (por ejemplo, longitud y formato)
        return dv != null && dv.length() == 1;
    }
    
    private boolean validarDireccion() {
        return direccion != null && !direccion.isEmpty() && direccion.length() <= 100 && direccion.length() >5;
    }
    
    private boolean validarNumeracion() {
        return numeracion != null && !numeracion.isEmpty() && numeracion.length() <=100 && numeracion.length() > 0 ;
    }
    
    public String getFullName() {
        return nombre + " " + apellido;
    }
    public String getFullRUT() {
        return rut + "-" + dv;
    }
}
