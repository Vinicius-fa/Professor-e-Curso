package com.weg.ProfessorECurso.mapper;

import com.weg.ProfessorECurso.dto.request.ProfessorRequestDto;
import com.weg.ProfessorECurso.dto.response.CursoResponseDto;
import com.weg.ProfessorECurso.dto.response.ProfessorResponseDto;
import com.weg.ProfessorECurso.model.Professor;
import com.weg.ProfessorECurso.dto.response.ProfessorComCursoResponseDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProfessorMapper {

    public Professor toEntity(ProfessorRequestDto dto) {
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        return professor;
    }

    public ProfessorResponseDto toResponse(Professor professor) {
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail()
        );
    }

    public ProfessorComCursoResponseDto toResponseComCursos(Professor professor) {
        List<CursoResponseDto> cursos = professor.getCursos() == null
                ? Collections.emptyList()
                : professor.getCursos().stream()
                .map(curso -> new CursoResponseDto(
                        curso.getId(),
                        curso.getTitulo(),
                        curso.getCargaHoraria(),
                        professor.getId(),
                        professor.getNome()
                ))
                .toList();

        return new ProfessorComCursoResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                cursos
        );
    }
}