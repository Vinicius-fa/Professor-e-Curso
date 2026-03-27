package com.weg.ProfessorECurso.service;

import com.weg.ProfessorECurso.dto.request.ProfessorRequestDto;
import com.weg.ProfessorECurso.dto.response.ProfessorComCursoResponseDto;
import com.weg.ProfessorECurso.dto.response.ProfessorResponseDto;
import com.weg.ProfessorECurso.mapper.ProfessorMapper;
import com.weg.ProfessorECurso.model.Professor;
import com.weg.ProfessorECurso.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository,
                            ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public ProfessorResponseDto salvar(ProfessorRequestDto dto) {
        Professor professor = professorMapper.toEntity(dto);
        return professorMapper.toResponse(professorRepository.save(professor));
    }

    public List<ProfessorResponseDto> listarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(professorMapper::toResponse)
                .toList();
    }

    public ProfessorComCursoResponseDto buscarComCursos(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + id));
        return professorMapper.toResponseComCursos(professor);
    }

    public Professor buscarEntidadePorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + id));
    }
}
