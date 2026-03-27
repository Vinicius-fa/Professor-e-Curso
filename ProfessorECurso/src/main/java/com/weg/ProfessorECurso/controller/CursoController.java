package com.weg.ProfessorECurso.controller;

import com.weg.ProfessorECurso.dto.request.CursoRequestDto;
import com.weg.ProfessorECurso.dto.response.CursoResponseDto;
import com.weg.ProfessorECurso.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrar(@RequestBody @Valid CursoRequestDto dto) {
        return ResponseEntity.status(201).body(cursoService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listar(
            @RequestParam(required = false) String nomeProfessor,
            @RequestParam(required = false) Long professorId) {

        if (nomeProfessor != null) {
            return ResponseEntity.ok(cursoService.buscarPorNomeProfessor(nomeProfessor));
        }
        if (professorId != null) {
            return ResponseEntity.ok(cursoService.buscarPorProfessorId(professorId));
        }
        return ResponseEntity.ok(cursoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> buscarPorId(
            @PathVariable Long id,
            @RequestParam(required = false) String titulo) {

        if (titulo != null) {
            return ResponseEntity.ok(cursoService.buscarPorIdETitulo(id, titulo));
        }
        return ResponseEntity.notFound().build();
    }
}