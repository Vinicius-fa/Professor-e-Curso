package com.weg.ProfessorECurso.service;

import com.weg.ProfessorECurso.dto.request.CursoRequestDto;
import com.weg.ProfessorECurso.dto.response.CursoResponseDto;
import com.weg.ProfessorECurso.mapper.CursoMapper;
import com.weg.ProfessorECurso.model.Curso;
import com.weg.ProfessorECurso.model.Professor;
import com.weg.ProfessorECurso.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfessorService professorService;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository,
                        ProfessorService professorService,
                        CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.professorService = professorService;
        this.cursoMapper = cursoMapper;
    }

    public CursoResponseDto salvar(CursoRequestDto dto) {
        Professor professor = professorService.buscarEntidadePorId(dto.professorId());

        Curso curso = new Curso();
        curso.setTitulo(dto.titulo());
        curso.setCargaHoraria(dto.cargaHoraria());
        curso.setProfessor(professor);

        return cursoMapper.toResponse(cursoRepository.save(curso));
    }

    public List<CursoResponseDto> listarTodos() {
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public List<CursoResponseDto> buscarPorNomeProfessor(String nome) {
        return cursoRepository.findByProfessorNomeContainingIgnoreCase(nome)
                .stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public List<CursoResponseDto> buscarPorProfessorId(Long professorId) {
        return cursoRepository.findByProfessorId(professorId)
                .stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public CursoResponseDto buscarPorIdETitulo(Long id, String titulo) {
        Curso curso = cursoRepository.findByIdAndTitulo(id, titulo)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        return cursoMapper.toResponse(curso);
    }
}