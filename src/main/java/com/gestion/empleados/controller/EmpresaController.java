package com.gestion.empleados.controller;

import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.model.Empleado;
import com.gestion.empleados.model.Empresa;
import com.gestion.empleados.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    //este metodo sirve para listar todos las empresas
    @GetMapping("/empresas")
    public List<Empresa> listAllEmpresas(){
        return empresaRepository.findAll();
    }


    //este metodo sirve para encontrar empresa por el id
    @GetMapping("/empresas/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id){
        Empresa empresa = empresaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("No existe la empresa con el id: " + id)));
        return ResponseEntity.ok(empresa);
    }


}

