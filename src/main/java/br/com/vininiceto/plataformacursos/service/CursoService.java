package br.com.vininiceto.plataformacursos.service;

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

    public Optional<Curso> findById(String id) {
        return Optional.of(repository.findById(Long.parseLong(id)).orElseThrow(() -> new CursoNotFound("Id invalid!")));
    }

    public List<Curso> findAllCurso(){
        return repository.findAll();
    }

    public Optional<Curso> findCursoByNameAndCategory(String name, String category) {
        return Optional.of(Optional.of(repository.findCursoByNameAndCategory(name, category)).orElseThrow(() -> new CursoNotFound("Name or category invalid!")));
    }

    public String deleteCurso(String id) {
        repository.deleteById(Long.parseLong(id));
        return "Course deleted as requested.";
    }

    public Curso changeStatusCurso(String id) {
        Curso curso = repository.findById(Long.parseLong(id)).orElseThrow(() -> new CursoNotFound("Id Invalid!"));
        curso.setActive(!curso.getActive());
        return repository.saveAndFlush(curso);
    }


}
