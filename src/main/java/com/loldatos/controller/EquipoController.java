package com.loldatos.controller;

import com.loldatos.dto.JugadorDto;
import com.loldatos.entity.Equipo;
import com.loldatos.service.EquipoService;
import com.loldatos.service.JugadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> getAll() {
        return equipoService.findAll();
    }
}
