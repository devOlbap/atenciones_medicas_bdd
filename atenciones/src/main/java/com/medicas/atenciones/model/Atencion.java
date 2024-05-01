package com.medicas.atenciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name="ATENCION")
public class Atencion {
    @Id
    @Column(
        nullable = false,
        name= "id"
    )
    private Long id;
    
    @Column(
        nullable = false,
        name= "fecha_atencion"
    )
    private String fecha_atencion;
    
    @Column(
        nullable = false,
        name= "medico_id"
    )
    private Long medico_id;
    @Column(
        nullable = false,
        name= "paciente_id"
    )
    private Long paciente_id;
    @Column(
        nullable = false,
        name= "estado"
    )
    private String estado;

    
    public Atencion() {}

    public Atencion(
        String fecha_atencion,
        Long medico_id,
        Long paciente_id,
        String estado
            
        ) {
            this.fecha_atencion = fecha_atencion ;
            this.medico_id = medico_id ;
            this.paciente_id = paciente_id ;
            this.estado = estado ;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMedico() {
        return medico_id;
    }

    public void setIdMedico(Long medico_id) {
        this.medico_id = medico_id;
    }

    public Long getIdPaciente() {
        return paciente_id;
    }

    public void setIdPaciente(Long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getFecha() {
        return fecha_atencion;
    }

    public void setFecha(String fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
