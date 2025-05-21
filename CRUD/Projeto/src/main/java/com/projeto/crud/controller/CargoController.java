package com.projeto.crud.controller;

import com.projeto.crud.dto.CargoDTO;
import com.projeto.crud.service.CargoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @PostMapping
    public ResponseEntity<CargoDTO> criarCargo(@Valid @RequestBody CargoDTO cargoDTO) {
        return ResponseEntity.ok(cargoService.criar(cargoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CargoDTO>> listarCargos() {
        return ResponseEntity.ok(cargoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> buscarCargoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cargoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDTO> atualizarCargo(@PathVariable Long id, @Valid @RequestBody CargoDTO dto) {
        return ResponseEntity.ok(cargoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCargo(@PathVariable Long id) {
        cargoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
