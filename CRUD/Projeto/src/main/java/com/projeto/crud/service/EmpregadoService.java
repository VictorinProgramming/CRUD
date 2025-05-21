package com.projeto.crud.service;

import com.projeto.crud.dto.EmpregadoDTO;
import com.projeto.crud.exception.ResourceNotFoundException;
import com.projeto.crud.model.Empregado;
import com.projeto.crud.model.Cargo;
import com.projeto.crud.repository.EmpregadoRepository;
import com.projeto.crud.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpregadoService {

    private final EmpregadoRepository empregadoRepository;
    private final CargoService cargoService;

    public EmpregadoDTO criar(EmpregadoDTO dto) {
        Cargo cargo = cargoService.buscarEntidadePorId(dto.getCargoId());

        Empregado empregado = Empregado.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .dataAdmissao(dto.getDataAdmissao())
                .cargo(cargo)
                .build();

        Empregado salvo = empregadoRepository.save(empregado);

        return toDTO(salvo);
    }

    public List<EmpregadoDTO> listarTodos(String nome, String cargoNome, Pageable pageable) {
        List<Empregado> empregados;

        if (nome != null && cargoNome != null) {
            empregados = empregadoRepository.findByNomeContainingIgnoreCaseAndCargo_NomeContainingIgnoreCase(nome, cargoNome);
        } else if (nome != null) {
            empregados = empregadoRepository.findByNomeContainingIgnoreCase(nome);
        } else if (cargoNome != null) {
            empregados = empregadoRepository.findByCargo_NomeContainingIgnoreCase(cargoNome);
        } else {
            empregados = empregadoRepository.findAll();
        }

        return empregados.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public EmpregadoDTO buscarPorId(Long id) {
        Empregado empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado com ID " + id + " não encontrado"));

        return toDTO(empregado);
    }

    public EmpregadoDTO atualizar(Long id, EmpregadoDTO dto) {
        Empregado empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado com ID " + id + " não encontrado"));

        Cargo cargo = cargoService.buscarEntidadePorId(dto.getCargoId());

        empregado.setNome(dto.getNome());
        empregado.setEmail(dto.getEmail());
        empregado.setDataAdmissao(dto.getDataAdmissao());
        empregado.setCargo(cargo);

        Empregado atualizado = empregadoRepository.save(empregado);

        return toDTO(atualizado);
    }

    public void deletar(Long id) {
        Empregado empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado com ID " + id + " não encontrado"));

        empregadoRepository.delete(empregado);
    }

    private EmpregadoDTO toDTO(Empregado e) {
        return EmpregadoDTO.builder()
                .id(e.getId())
                .nome(e.getNome())
                .email(e.getEmail())
                .dataAdmissao(e.getDataAdmissao())
                .cargoId(e.getCargo().getId())
                .cargoNome(e.getCargo().getNome())
                .build();
    }

}
