package com.projeto.crud.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "empregados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;
}
