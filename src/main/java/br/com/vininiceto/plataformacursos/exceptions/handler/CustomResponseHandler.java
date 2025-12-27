package br.com.vininiceto.plataformacursos.exceptions.handler;

import br.com.vininiceto.plataformacursos.exceptions.CursoNotFound;
import br.com.vininiceto.plataformacursos.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@ControllerAdvice
public class CustomResponseHandler {

    private final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    @ExceptionHandler(CursoNotFound.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {

        LocalDateTime ldt = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        ExceptionResponse response = new ExceptionResponse(dtm.format(ldt), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);


    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {

        LocalDateTime ldt = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        ExceptionResponse response = new ExceptionResponse(dtm.format(ldt), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);


    }


}
