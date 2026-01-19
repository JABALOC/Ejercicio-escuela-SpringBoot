package com.hibernate.escuelaSpringBoot.controller;

import com.hibernate.escuelaSpringBoot.entity.Asignatura;
import com.hibernate.escuelaSpringBoot.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @GetMapping("/all")
    public List<Asignatura> getAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @GetMapping("/asignatura/{id}")
    public ResponseEntity<Asignatura> getAsignatura(@PathVariable Long id) {
        Optional<Asignatura> asignatura = asignaturaRepository.findById(id);
        return asignatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/create")
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
        Asignatura sAsignatura = asignaturaRepository.save(asignatura);
        return ResponseEntity.ok(sAsignatura);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable Long id) {
        if (!asignaturaRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        }
        asignaturaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        if (!asignaturaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        asignatura.setId(id);
        Asignatura sAsigatura = asignaturaRepository.save(asignatura);
        return ResponseEntity.ok(sAsigatura);
    }

}
