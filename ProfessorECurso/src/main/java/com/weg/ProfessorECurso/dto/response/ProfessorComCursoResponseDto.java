package com.weg.ProfessorECurso.dto.response;

import java.util.List;

public record ProfessorComCursoResponseDto (
        Long id,
        String nome,
        String email,
        List<CursoResponseDto> cursos
){
}
