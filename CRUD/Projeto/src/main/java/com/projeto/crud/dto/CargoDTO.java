package com.projeto.crud.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CargoDTO {

    private Long id;

    private String nome;

    private String descricao;
}
