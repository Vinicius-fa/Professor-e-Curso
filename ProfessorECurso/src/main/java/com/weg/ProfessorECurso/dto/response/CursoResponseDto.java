package com.weg.ProfessorECurso.dto.response;

import java.util.List;

public record CursoResponseDto(
        Long id,
        String titulo,
        Integer cargaHoraria,
        Long professorId,
        String professorNome
) {
}
