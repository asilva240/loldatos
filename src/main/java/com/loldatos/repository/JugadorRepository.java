package com.loldatos.repository;

import com.loldatos.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    List<Jugador> findByEquipoId(Long equipoId);
}
