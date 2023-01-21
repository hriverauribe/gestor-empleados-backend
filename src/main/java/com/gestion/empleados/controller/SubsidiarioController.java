package com.gestion.empleados.controller;

import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.model.Empresa;
import com.gestion.empleados.model.Subsidiario;
import com.gestion.empleados.repository.SubsidiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class SubsidiarioController {

    @Autowired
    SubsidiarioRepository subsidiarioRepository;

    //metodo para obtener todos los subsidiarios
    @GetMapping("/subsidiarios")
    public List<Subsidiario> getAllSubsidiarios(){
        return subsidiarioRepository.findAll();
    }

    //este metodo sirve para encontrar subsidiario por el id
    @GetMapping("/subsidiarios/{id}")
    public ResponseEntity<Subsidiario> getSubsidiarioById(@PathVariable Long id){
        Subsidiario subsidiario = subsidiarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("No existe el subsidiario con el id: " + id)));
        return ResponseEntity.ok(subsidiario);
    }
}
