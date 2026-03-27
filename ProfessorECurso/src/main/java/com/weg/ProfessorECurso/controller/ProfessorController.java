package com.weg.ProfessorECurso.controller;

import com.weg.ProfessorECurso.dto.request.ProfessorRequestDto;
import com.weg.ProfessorECurso.dto.response.ProfessorComCursoResponseDto;
import com.weg.ProfessorECurso.dto.response.ProfessorResponseDto;
import com.weg.ProfessorECurso.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> cadastrar(@RequestBody @Valid ProfessorRequestDto dto) {
        return ResponseEntity.status(201).body(professorService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listar() {
        return ResponseEntity.ok(professorService.listarTodos());
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<ProfessorComCursoResponseDto> buscarComCursos(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.buscarComCursos(id));
    }
}