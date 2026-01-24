package com.example.demo.controller;

import com.example.demo.entity.Estudiante;
import com.example.demo.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/estudiantes")

// Etiqueta para personalizar el nombre en Swagger
@Tag(name = "Gestión de Estudiantes", description = "API para el mantenimiento de estudiantes del Instituto")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

// LISTAR TODOS
    @Operation(summary = "Listar todos los estudiantes", description = "Obtiene una lista de todos los registros vigentes en la base de datos")
    @GetMapping
    public ResponseEntity<List<Estudiante>> listarTodos() {
        List<Estudiante> estudiantes = estudianteService.listarTodos();
        return ResponseEntity.ok(estudiantes);
    }

//OBTENER POR ID
    @Operation(summary = "Obtener un estudiante por ID", description = "Busca un estudiante específico usando su identificador único")
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerPorId(id);
        return ResponseEntity.ok(estudiante);
    }

//CREAR NUEVO
    @Operation(summary = "Registrar un nuevo estudiante", description = "Crea un nuevo registro de estudiante validando que los datos cumplan con los requisitos técnicos")
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@Valid @RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.guardar(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

//ACTUALIZAR
    @Operation(summary = "Actualizar información de un estudiante", description = "Permite modificar los datos de un estudiante existente mediante su ID")
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(
            @PathVariable Long id,
            @Valid @RequestBody Estudiante estudiante) {
        Estudiante actualizado = estudianteService.actualizar(id, estudiante);
        return ResponseEntity.ok(actualizado);
    }

//ELIMINAR
    @Operation(summary = "Eliminar un estudiante", description = "Borra permanentemente el registro de un estudiante de la base de datos")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}