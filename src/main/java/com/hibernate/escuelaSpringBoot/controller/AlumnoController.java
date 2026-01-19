package com.hibernate.escuelaSpringBoot.controller;

import com.hibernate.escuelaSpringBoot.entity.Alumno;
import com.hibernate.escuelaSpringBoot.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Consultar todos los alumnos
    @GetMapping("/all")
    public List<Alumno> getAlumnos(Long id) {
       return alumnoRepository.findAll();
    }

    // Consultar alumno por id
    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> getAlumno (@PathVariable Long id) {
        Optional<Alumno> alumnoOpt = alumnoRepository.findById(id);
        return alumnoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear alumno
    @PutMapping("/create")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        Alumno saveAlumno = alumnoRepository.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveAlumno);
    }

    // Eliminar alumno
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        if (!alumnoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alumnoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar alumno
    @PutMapping("/update/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        if (!alumnoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alumno.setId(id);
        Alumno savedAlumno = alumnoRepository.save(alumno);
        return ResponseEntity.ok(savedAlumno);
    }

}
