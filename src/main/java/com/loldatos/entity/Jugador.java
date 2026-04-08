package com.loldatos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(
        name = "jugador",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_jugador_nick", columnNames = "nick")
        }
)
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "nick", nullable = false, length = 50)
    private String nick;

    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;

    @Column(name = "fecha_nacimiento")
    private Date fechaNamimiento;

    @Column(name = "liga", nullable = false, length = 50)
    private String liga;

    /**
     * Relación N-1: muchos jugadores pertenecen a un equipo.
     * JsonIgnoreProperties evita bucles al serializar.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "equipo_id", foreignKey = @ForeignKey(name = "fk_jugador_equipo"))
    @JsonIgnoreProperties({"jugadores"})
    private Equipo equipo;

    public Jugador() {}

    // getters/setterss
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getNick() { return nick; }
    public void setNick(String nick) { this.nick = nick; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public Date getFechaNamimiento() {
        return fechaNamimiento;
    }

    public void setFechaNamimiento(Date fechaNamimiento) {
        this.fechaNamimiento = fechaNamimiento;
    }

    public String getLiga() { return liga; }
    public void setLiga(String liga) { this.liga = liga; }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
