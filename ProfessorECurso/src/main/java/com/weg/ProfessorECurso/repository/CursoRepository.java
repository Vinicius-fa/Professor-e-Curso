package com.weg.ProfessorECurso.repository;

import com.weg.ProfessorECurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByProfessorId(Long professorId);

    List<Curso> findByProfessorNomeContainingIgnoreCase(String nome);

    Optional<Curso> findByIdAndTitulo(Long id, String titulo);
}
