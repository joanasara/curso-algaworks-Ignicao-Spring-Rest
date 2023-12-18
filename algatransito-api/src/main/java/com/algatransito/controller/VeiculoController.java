package com.algatransito.controller;

import com.algatransito.domain.model.Veiculo;
import com.algatransito.domain.repository.VeiculoRepository;
import com.algatransito.domain.service.RegistroVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;

    private final RegistroVeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();

    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoService.cadastrar(veiculo);
    }
}
