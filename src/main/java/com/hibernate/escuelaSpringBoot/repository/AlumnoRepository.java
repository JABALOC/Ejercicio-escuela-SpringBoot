package com.hibernate.escuelaSpringBoot.repository;

import com.hibernate.escuelaSpringBoot.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
