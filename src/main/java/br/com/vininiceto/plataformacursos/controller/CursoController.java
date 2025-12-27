package br.com.vininiceto.plataformacursos.controller;

import br.com.vininiceto.plataformacursos.model.Curso;
import br.com.vininiceto.plataformacursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    CursoService service;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> findCursoById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping("/{name}/{category}")
    public ResponseEntity<Optional<Curso>> findCursoByNameAndCategory(@PathVariable String name, @PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findCursoByNameAndCategory(name, category));
    }


    @PostMapping("/create")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCurso(curso));
    }


}
