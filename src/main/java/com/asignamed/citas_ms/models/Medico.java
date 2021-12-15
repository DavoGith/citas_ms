package com.asignamed.citas_ms.models;
import org.springframework.data.annotation.Id;

public class Medico {
    @Id
    private String username;
    private String especialidad;

    public Medico(String username, String especialidad) {
        this.username = username;
        this.especialidad = especialidad;
    }

    public String getUsername() {
        return username;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEspecialidad(String especialidad) {this.especialidad = especialidad; }
}
