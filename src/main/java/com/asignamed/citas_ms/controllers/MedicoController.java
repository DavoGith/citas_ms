package com.asignamed.citas_ms.controllers;

import com.asignamed.citas_ms.exceptions.MedicoNotFoundException;
import com.asignamed.citas_ms.models.Medico;
import com.asignamed.citas_ms.repositories.MedicoRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @GetMapping("/medico/{username}")
    Medico getMedico(@PathVariable String username){
        return medicoRepository.findById(username)
                .orElseThrow(() -> new MedicoNotFoundException("No se encontró un medico " +
                        "con el username: " + username));
    }
    @PostMapping("/medico")
    Medico newAccount(@RequestBody Medico account){
        return medicoRepository.save(account);
    }
}
