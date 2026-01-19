package com.hibernate.escuelaSpringBoot.repository;

import com.hibernate.escuelaSpringBoot.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
