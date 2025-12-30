package br.com.vininiceto.plataformacursos.controller;

import br.com.vininiceto.plataformacursos.model.Curso;
import br.com.vininiceto.plataformacursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/todos")
    public ResponseEntity<Optional<List<Curso>>> findAllCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(service.findAllCurso()));
    }

    @GetMapping("/{name}/{category}")
    public ResponseEntity<Optional<Curso>> findCursoByNameAndCategory(@PathVariable String name, @PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findCursoByNameAndCategory(name, category));
    }


    @PostMapping("/create")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCurso(curso));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteCurso(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<Optional<Curso>> changeStatus(@PathVariable String id){
        Curso cursoAtualizado = service.changeStatusCurso(id);
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(cursoAtualizado));
    }


}
