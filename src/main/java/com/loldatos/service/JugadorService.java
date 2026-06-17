package com.loldatos.service;

import com.loldatos.dto.JugadorDto;
import com.loldatos.entity.Jugador;
import com.loldatos.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<JugadorDto> findAll() {
        return jugadorRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public List<JugadorDto> findJugadoresEquipo(Long equipoId) {
        return jugadorRepository.findByEquipoId(equipoId).stream()
                .map(this::toDto)
                .toList();
    }

    private JugadorDto toDto(Jugador j) {
        return new JugadorDto(
                j.getId(),
                j.getNombre(),
                j.getApellidos(),
                j.getNick(),
                j.getNacionalidad(),
                j.getFechaNacimiento(),
                j.getLiga(),
                j.getEquipo() != null ? j.getEquipo().getId() : null,
                j.getEquipo() != null ? j.getEquipo().getNombre() : null
        );
    }
}

