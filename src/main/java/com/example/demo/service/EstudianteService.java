package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    //LISTAR
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    //GUARDAR
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);  // Spring maneja el error
    }

    // BUSCAR POR ID
    public Estudiante obtenerPorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Estudiante no encontrado con id: " + id));
    }

    // ACTUALIZAR
    @Transactional
    public Estudiante actualizar(Long id, Estudiante estudianteActualizado) {
        // Busca al estudiante
        Estudiante estudianteExistente = obtenerPorId(id);

        // Actualiza campos
        estudianteExistente.setCedula(estudianteActualizado.getCedula());
        estudianteExistente.setNombre(estudianteActualizado.getNombre());
        estudianteExistente.setEmail(estudianteActualizado.getEmail());
        estudianteExistente.setEdad(estudianteActualizado.getEdad());
        estudianteExistente.setCarrera(estudianteActualizado.getCarrera());

        // Guarda - Spring maneja el error
        return estudianteRepository.save(estudianteExistente);
    }

    // ELIMINAR
    @Transactional
    public void eliminar(Long id) {
        // 1. Verificar que existe
        Estudiante estudiante = obtenerPorId(id);

        estudianteRepository.delete(estudiante);
    }
}