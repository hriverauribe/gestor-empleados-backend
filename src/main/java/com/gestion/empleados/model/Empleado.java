package com.gestion.empleados.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter @Setter
@Entity
@Table(name ="empleados")

public class Empleado {

    public Empleado() {

    }

    public Empleado(Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    @Column(name="nombre",length = 60,nullable = false)
    private String nombre;


    @Column(name="apellido",length = 60,nullable = false)
    private String apellido;


    @Column(name="email",length = 60,nullable = false,unique = true)
    private String email;


}