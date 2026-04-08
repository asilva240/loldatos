package com.loldatos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "nacionalidad", nullable = false, length = 50)
    private String nacionalidad;

    /**
     * Guardamos el logo como URL o ruta (VARCHAR en BD).
     */
    @Column(name = "logo", length = 255)
    private String logo;

    @Column(name = "liga", nullable = false, length = 50)
    private String liga;

    /**
     * Relación 1-N: un equipo tiene muchos jugadores.
     * JsonIgnore para evitar bucle infinito al devolver JSON.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY)
    private List<Jugador> jugadores = new ArrayList<>();

    public Equipo() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }

    public String getLiga() { return liga; }
    public void setLiga(String liga) { this.liga = liga; }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
