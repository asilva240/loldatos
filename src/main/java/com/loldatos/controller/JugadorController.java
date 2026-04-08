package com.loldatos.controller;

import com.loldatos.dto.JugadorDto;
import com.loldatos.service.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<JugadorDto> getAll() {
        return jugadorService.findAll();
    }

    @GetMapping("/equipo")
    public List<JugadorDto> getJugadoresEquipo(Long equipoId) {
        return jugadorService.findJugadoresEquipo(equipoId);
    }
}

