package com.loldatos.service;

import com.loldatos.dto.JugadorDto;
import com.loldatos.entity.Equipo;
import com.loldatos.repository.EquipoRepository;
import com.loldatos.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }
}
