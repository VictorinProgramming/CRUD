package com.projeto.crud.service;

import com.projeto.crud.dto.CargoDTO;
import com.projeto.crud.exception.ResourceNotFoundException;
import com.projeto.crud.model.Cargo;
import com.projeto.crud.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoDTO criar(CargoDTO dto) {
        Cargo cargo = new Cargo();
        cargo.setNome(dto.getNome());
        cargo.setDescricao(dto.getDescricao());

        Cargo salvo = cargoRepository.save(cargo);

        return new CargoDTO(salvo.getId(), salvo.getNome(), salvo.getDescricao());
    }

    public List<CargoDTO> listarTodos() {
        return cargoRepository.findAll()
                .stream()
                .map(c -> new CargoDTO(c.getId(), c.getNome(), c.getDescricao()))
                .collect(Collectors.toList());
    }

    public CargoDTO buscarPorId(Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo com ID " + id + " não encontrado"));

        return new CargoDTO(cargo.getId(), cargo.getNome(), cargo.getDescricao());
    }

    public CargoDTO atualizar(Long id, CargoDTO dto) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo com ID " + id + " não encontrado"));

        cargo.setNome(dto.getNome());
        cargo.setDescricao(dto.getDescricao());

        Cargo atualizado = cargoRepository.save(cargo);

        return new CargoDTO(atualizado.getId(), atualizado.getNome(), atualizado.getDescricao());
    }

    public void deletar(Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo com ID " + id + " não encontrado"));

        cargoRepository.delete(cargo);
    }

    public Cargo buscarEntidadePorId(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo com ID " + id + " não encontrado"));
    }
}
