package br.com.vininiceto.plataformacursos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CursoNotFound extends RuntimeException {
    public CursoNotFound(String message) {
        super(message);
    }
}
