package com.projeto.crud.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpregadoDTO {

    private Long id;

    private String nome;

    private String email;

    private LocalDate dataAdmissao;

    private Long cargoId;      // Usado na criação/atualização

    private String cargoNome;  // Usado na resposta
}
