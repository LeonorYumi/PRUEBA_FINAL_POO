# Sistema de Gestión de Estudiantes - API REST

---

## Descripción del Proyecto
Este proyecto es una API REST desarrollada para la gestión de estudiantes de un instituto. La aplicación implementa operaciones CRUD completas y un sistema robusto de validación y manejo de excepciones globales para garantizar respuestas claras al cliente.

---

## Autores
- Bueno Camila
- Yumi Leonor

Carrera: Tecnología Superior en Desarrollo de Software 

Asignatura: Programación Orientada a Objetos 

---

## Tecnologías Utilizadas

Para el desarrollo se utilizaron las siguientes tecnologías:

**Lenguaje:** Java 21

**Framework:** Spring Boot 3.2.5

**Gestión de Dependencias:** Maven

**Base de Datos:** H2 Database (Motor en memoria con persistencia en archivo local) 

**Persistencia:** Spring Data JPA / Hibernate 

**Documentación:** Swagger UI (OpenAPI 3) 

**Pruebas:** Postman

**Frontend:** Archivos estáticos (HTML5, CSS3, JavaScript)

---

## Estructura del Proyecto (Arquitectura en Capas)
Se trabajó la estructura del proyecto con Arquitectura en capas.


**Controller:** Gestión de endpoints y peticiones HTTP con @RestController.


**Service:** Lógica de negocio con la anotación @Service.


**Repository:** Acceso a datos mediante Spring Data JPA y @Repository.


**Entity:** Modelo de datos Estudiante con validaciones.


**Exception:** Manejo global de errores con @ControllerAdvice.

---

## Funcionalidades y Endpoints
El proyecto cuenta con 5 edpoints:


**GET /api/estudiantes:** Listar todos los registros.


**GET /api/estudiantes/{id}:** Obtener un registro por ID.


**POST /api/estudiantes:** Crear un nuevo registro.


**PUT /api/estudiantes/{id}:** Actualizar un registro existente.


**DELETE /api/estudiantes/{id}:** Eliminar un registro.

---

## Manejo de Errores
El sistema utiliza un @ControllerAdvice para devolver respuestas JSON estructuradas con los siguientes códigos HTTP:


**400 (Bad Request):** Errores de validación en los campos enviados (Nombre, Email, Edad, Carrera).

**404 (Not Found):** Se dispara una excepción personalizada cuando se busca un ID que no existe.

**409 (Conflict):** Manejo especializado para Cédulas Duplicadas (DataIntegrityViolationException).

**500 (Internal Server Error):** Captura de errores inesperados del sistema para evitar caídas del servicio.

---

## Validaciones de Datos 
Se aplican las siguientes restricciones en la entidad Estudiante:

- Nombre y Carrera: Obligatorios (@NotBlank) con longitud controlada (@Size).

- Email: Formato de correo electrónico válido obligatorio (@Email).

-- Edad: Restringida a un rango entre 16 y 60 años (@Min, @Max).

---

## Entregables Adicionales

**Postman:** Colección de pruebas Estudiantes_API_Collection.json incluida en el repositorio.

**Swagger:** Documentación interactiva disponible en http://localhost:8080/swagger-ui/index.html

**Base de Datos:** Uso de H2 con datos de prueba precargados en data.sql.

---

## Ejecución del proyecto

1. Clonar el repositorio.

2. Abrir en IntelliJ IDEA y refrescar Maven.

3. Ejecutar la clase principal GestionEstudiantesApplication.

- Acceder a Swagger en: http://localhost:8080/swagger-ui.html

**Frontend**

Acceda desde su navegador a: http://localhost:8080/index.html 

Consola H2: Administre la base de datos directamente en: http://localhost:8080/h2-console

---

## Despliegue (Cloud Deployment)
El proyecto ha sido empaquetado usando Docker y desplegado en la plataforma Render.

URL del Proyecto: https://prueba-final-poo.onrender.com/ 

Nota: La aplicación utiliza una base de datos H2 en memoria y el plan gratuito de Render. 

Si el enlace tarda en cargar, por favor espere aproximadamente 5 minutos mientras el contenedor se inicia (Cold Start). Los datos iniciales se cargan automáticamente desde el archivo data.sql.


