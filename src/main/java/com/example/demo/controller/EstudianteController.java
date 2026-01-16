package com.example.demo.controller;

import com.example.demo.model.Estudiante;
import com.example.demo.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//recibe peticiones
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Listar
    @GetMapping
    public List<Estudiante> listar() {
        return estudianteService.listarTodos();
    }

    // Crear
    @PostMapping
    public Estudiante crear(@Valid @RequestBody Estudiante estudiante) {
        return estudianteService.guardar(estudiante);
    }

    @GetMapping("/{id}")
    public Estudiante obtenerPorId(@PathVariable Long id) {
        return estudianteService.obtenerPorId(id);
    }

}
