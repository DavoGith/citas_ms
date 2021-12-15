package com.asignamed.citas_ms.controllers;
import com.asignamed.citas_ms.exceptions.MedicoNotFoundException;
import com.asignamed.citas_ms.exceptions.CitaNotFoundException;
import com.asignamed.citas_ms.models.Medico;
import com.asignamed.citas_ms.models.Citas;
import com.asignamed.citas_ms.repositories.MedicoRepository;
import com.asignamed.citas_ms.repositories.CitasRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController

public class CitaController {

    private final MedicoRepository medicoRepository;
    private final CitasRepository citasRepository;

    public CitaController(MedicoRepository medicoRepository, CitasRepository citasRepository) {
        this.medicoRepository = medicoRepository;
        this.citasRepository = citasRepository;
    }

    @PostMapping("/citas")
    Citas newTransaction(@RequestBody Citas citas){
        List<Medico> especialidad = medicoRepository.findByEspecialidad(citas.getEspecialidad());

        if (especialidad.size() < 1)
            throw new MedicoNotFoundException("No se encontró un memdico disponible: " + citas.getEspecialidad());

        List<Citas> citasEncontradas = citasRepository.findByFechaCitaAndMedicoAndHoraCita(citas.getFechaCita(), citas.getMedico(), citas.getHoraCita());
        if (citasEncontradas.size() > 0)
            throw new CitaNotFoundException("Para la fecha indicada no está disponibe el medico" + citas.getMedico());


        return citasRepository.save(citas);
    }
    @GetMapping("/citas/{username}")
    List<Citas> userCitas(@PathVariable String username){
        List<Citas> citas = citasRepository.findByPaciente(username);;
        if (citas.size() <1)
            throw new CitaNotFoundException("No se encontró citas para el paciente " + username);

        return citas;
    }

}
