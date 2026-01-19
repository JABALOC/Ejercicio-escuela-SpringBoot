package com.hibernate.escuelaSpringBoot.controller;

import com.hibernate.escuelaSpringBoot.entity.Profesor;
import com.hibernate.escuelaSpringBoot.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping("/all")
    public List<Profesor> getProfesores() {
        return profesorRepository.findAll();
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<Profesor> getProfesor(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        return profesor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/create")
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor) {
        Profesor sProfesor = profesorRepository.save(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(sProfesor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        if (!profesorRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        }
        profesorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        if (!profesorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        profesor.setId(id);
        Profesor sProfesor = profesorRepository.save(profesor);
        return ResponseEntity.ok(sProfesor);

    }

}
