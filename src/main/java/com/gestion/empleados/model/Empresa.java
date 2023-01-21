package com.gestion.empleados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="empresa")
public class Empresa {

    public Empresa() {
    }

    public Empresa(Long id, String nombre, String direccion, String ciudad, String codigo_postal, String telefono, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono;
        this.estado = estado;

    }

    @Id
    @Column(name="id_empresa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="nombre",length = 60,nullable = false)
    private String nombre;


    @Column(name="direccion",length = 255,nullable = false)
    private String direccion;


    @Column(name="ciudad",length = 255,nullable = false)
    private String ciudad;

    @Column(name="codigo_postal",length = 255,nullable = false)
    private String codigo_postal;

    @Column(name="telefono",length = 255,nullable = false)
    private String telefono;

    @Column(name="estado",length = 255,nullable = false)
    private String estado;




}
