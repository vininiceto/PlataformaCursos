package br.com.vininiceto.plataformacursos.service;

import br.com.vininiceto.plataformacursos.dto.CursosPutDto;
import br.com.vininiceto.plataformacursos.exceptions.CursoNotFound;
import br.com.vininiceto.plataformacursos.model.Curso;
import br.com.vininiceto.plataformacursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository repository;


    public Curso createCurso(Curso curso) {

        return repository.saveAndFlush(curso);
    }

    public Optional<Curso> findById(Long id) {
        return Optional.of(repository.findById(id).orElseThrow(() -> new CursoNotFound("Id invalid!")));
    }

    public List<Curso> findAllCurso() {
        return repository.findAll();
    }

    public Optional<Curso> findCursoByNameAndCategory(String name, String category) {
        return Optional.of(Optional.of(repository.findCursoByNameAndCategory(name, category)).orElseThrow(() -> new CursoNotFound("Name or category invalid!")));
    }

    public String deleteCurso(Long id) {
        repository.deleteById(id);
        return "Course deleted as requested.";
    }

    public Curso changeStatusCurso(Long id) {
        Curso curso = repository.findById(id).orElseThrow(() -> new CursoNotFound("Id Invalid!"));
        curso.setActive(!curso.getActive());
        return repository.saveAndFlush(curso);
    }

    public Curso changeNameOrCategory(Long id, CursosPutDto cursoDto) {
        Curso curso = repository.findById(id).orElseThrow(() -> new CursoNotFound("Id Invalid!"));
        if (cursoDto.getName() != null) {
            curso.setName(cursoDto.getName());
        }
        if (cursoDto.getCategory() != null) {
            curso.setCategory(cursoDto.getCategory());
        }
        return repository.saveAndFlush(curso);
    }

}
