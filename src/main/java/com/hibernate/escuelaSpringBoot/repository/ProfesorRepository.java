package com.hibernate.escuelaSpringBoot.repository;

import com.hibernate.escuelaSpringBoot.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
