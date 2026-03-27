package com.weg.ProfessorECurso.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequestDto(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @NotBlank(message = "Email é obrigatório") String email
) {
}
