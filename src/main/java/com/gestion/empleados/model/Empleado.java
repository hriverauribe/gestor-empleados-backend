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

    public Empleado(Long id, String nombre, String apellido, String email, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.empresa = empresa;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="nombre",length = 60,nullable = false)
    private String nombre;


    @Column(name="apellido",length = 60,nullable = false)
    private String apellido;


    @Column(name="email",length = 60,nullable = false,unique = true)
    private String email;

    @ManyToOne
    @JoinColumn (name="id_empresa")
    private Empresa empresa;


}