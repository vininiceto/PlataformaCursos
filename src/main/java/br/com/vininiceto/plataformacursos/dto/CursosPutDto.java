package br.com.vininiceto.plataformacursos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursosPutDto {
    @NotBlank
    private String name;
    @NotBlank
    private String category;


}
