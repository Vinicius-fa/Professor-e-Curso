package com.weg.ProfessorECurso.mapper;

import com.weg.ProfessorECurso.dto.response.CursoResponseDto;
import com.weg.ProfessorECurso.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoResponseDto toResponse(Curso curso) {
        return new CursoResponseDto(
                curso.getId(),
                curso.getTitulo(),
                curso.getCargaHoraria(),
                curso.getProfessor().getId(),
                curso.getProfessor().getNome()
        );
    }
}