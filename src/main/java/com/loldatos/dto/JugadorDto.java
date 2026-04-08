package com.loldatos.dto;

import java.util.Date;

public record JugadorDto(
        Long id,
        String nombre,
        String apellidos,
        String nick,
        String nacionalidad,
        Date fecha_nacimiento,
        String liga,
        Long equipoId,
        String equipoNombre
) {}
