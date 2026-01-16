package com.example.demo.repository;

import com.example.demo.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Nos ayuda con el acesso a la BD
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}