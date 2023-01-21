package com.gestion.empleados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="subsidiario")
public class Subsidiario {

    public Subsidiario() {

    }

    public Subsidiario(Long id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Id
    @Column(name="id_subsidiario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="nombre",length = 60,nullable = false)
    private String nombre;


    @Column(name="direccion",length = 255,nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn (name="id_empresa")
    private Empresa empresa;



}
