package com.weg.ProfessorECurso.repository;

import com.weg.ProfessorECurso.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}