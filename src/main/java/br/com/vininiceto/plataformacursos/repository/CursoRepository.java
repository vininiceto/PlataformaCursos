package br.com.vininiceto.plataformacursos.repository;

import br.com.vininiceto.plataformacursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {


    Curso findCursoByNameAndCategory(String name, String category);



}
