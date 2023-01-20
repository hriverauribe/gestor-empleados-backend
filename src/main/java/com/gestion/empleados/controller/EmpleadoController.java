package com.gestion.empleados.controller;

import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.model.Empleado;
import com.gestion.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    //este metodo sirve para listar todos los empleados
    @GetMapping("/empleados")
    public List<Empleado> listAllEmpleados(){
        return empleadoRepository.findAll();
    }

    //este metodo sirve para guardar el empleado
    @PostMapping("/empleados")
    public Empleado saveEmpleado(@RequestBody Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    //este metodo sirve para encontrar empleado por el id
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id){
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("No existe el empleado con el id: " + id)));
    return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("No existe el empleado con el id: " + id)));

        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());

        Empleado empleadoActualizado = empleadoRepository.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmpleado(@PathVariable Long id){
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        empleadoRepository.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

