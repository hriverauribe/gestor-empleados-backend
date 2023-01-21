package com.gestion.empleados.repository;

import com.gestion.empleados.model.Subsidiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidiarioRepository extends JpaRepository<Subsidiario, Long> {
}
