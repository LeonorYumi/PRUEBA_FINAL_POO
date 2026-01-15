package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50)
    private String nombre;

    @NotBlank @Email
    private String email;

    @NotNull @Min(16) @Max(60)
    private Integer edad;

    @NotBlank
    private String carrera;

    // Constructor vacío
    public Estudiante() {}

    // Getters y Setters
    public Long getId() {
        return id; }
    public void setId(Long id) {
        this.id = id; }
    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }
    public String getEmail() {
        return email; }
    public void setEmail(String email) {
        this.email = email; }
    public Integer getEdad() {
        return edad; }
    public void setEdad(Integer edad) {
        this.edad = edad; }
    public String getCarrera() {
        return carrera; }
    public void setCarrera(String carrera) {
        this.carrera = carrera; }
}