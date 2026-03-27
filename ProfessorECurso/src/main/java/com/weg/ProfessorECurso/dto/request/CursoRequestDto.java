package com.weg.ProfessorECurso.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CursoRequestDto(
        @NotBlank(message = "Título é obrigatório") String titulo,
        @NotNull(message = "Carga horária é obrigatória") @Positive(message = "Carga horária deve ser positiva") Integer cargaHoraria,
        @NotNull(message = "Professor é obrigatório") Long professorId
) {
}
