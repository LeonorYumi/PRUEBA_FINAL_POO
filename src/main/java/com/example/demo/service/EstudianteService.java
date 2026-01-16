package com.example.demo.service;
import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Buscar por ID (AQUÍ SE LANZA EL ERROR)
    public Estudiante obtenerPorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Estudiante no encontrado con id: " + id
                        )
                );
    }
}
