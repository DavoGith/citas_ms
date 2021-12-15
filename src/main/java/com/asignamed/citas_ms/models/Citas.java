package com.asignamed.citas_ms.models;
import org.springframework.data.annotation.Id;
import java.util.Date;

public class Citas {
    @Id
    private String id;
    private String paciente;
    private Date fechaCita;
    private Integer horaCita;
    private String medico;
    private String especialidad;

    public Citas(String id, String paciente, Date fechaCita, Integer horaCita, String medico, String especialidad) {
        this.id = id;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.medico = medico;
        this.especialidad = especialidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Integer getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Integer horaCita) {
        this.horaCita = horaCita;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
