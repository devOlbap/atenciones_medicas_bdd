package com.medicas.atenciones.model;

public class AtencionResponse {
    private Long id_atencion;
    private String medico;
    private String paciente;
    private String fecha_atencion;
    private String estado;

    public AtencionResponse(
        Long id_atencion,
        String medico,
        String paciente,
        String fecha_atencion,
        String estado
    ) {
        this.id_atencion = id_atencion;
        this.medico =  medico;
        this.paciente =  paciente;
        this.fecha_atencion =  fecha_atencion;
        this.estado =  estado;
    }

    // Agrega getters y setters
    public Long getIdAtencion() {
        return id_atencion;
    }

    public void setIdAtencion(Long id) {
        this.id_atencion = id;
    }
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
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
