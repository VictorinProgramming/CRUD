package com.projeto.crud.controller;

import com.projeto.crud.dto.EmpregadoDTO;
import com.projeto.crud.service.EmpregadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empregados")
@RequiredArgsConstructor
public class EmpregadoController {

    private final EmpregadoService empregadoService;

    @PostMapping
    public ResponseEntity<EmpregadoDTO> criarEmpregado(@Valid @RequestBody EmpregadoDTO empregadoDTO) {
        EmpregadoDTO criado = empregadoService.criar(empregadoDTO);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<Page<EmpregadoDTO>> listarEmpregados(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cargo,
            Pageable pageable
    ) {
        Page<EmpregadoDTO> empregados = empregadoService.listarEmpregados(nome, cargo, pageable);
        return ResponseEntity.ok(empregados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpregadoDTO> buscarPorId(@PathVariable Long id) {
        EmpregadoDTO dto = empregadoService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpregadoDTO> atualizarEmpregado(@PathVariable Long id,
                                                           @Valid @RequestBody EmpregadoDTO dto) {
        EmpregadoDTO atualizado = empregadoService.atualizarEmpregado(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpregado(@PathVariable Long id) {
        empregadoService.deletarEmpregado(id);
        return ResponseEntity.noContent().build();
    }
}
