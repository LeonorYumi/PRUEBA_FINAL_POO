package com.example.demo.repository;

import com.example.demo.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//Acesso a la bd
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // metodo para buscar por cédula
    Optional<Estudiante> findByCedula(String cedula);

    boolean existsByCedula(String cedula);
}