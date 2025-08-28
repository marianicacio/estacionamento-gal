package com.example.estacionamento.controller;

import com.example.estacionamento.model.Veiculo;
import com.example.estacionamento.repository.VeiculoRepository;
import com.example.estacionamento.service.VeiculoService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/veiculo")


public class VeiculoController {

    @Autowired

    private VeiculoService service;

    @PostMapping("/entrada")

    public ResponseEntity<Veiculo> registrarEntrada(@RequestBody Veiculo veiculo) {
        veiculo.setValor_hr(25.00); //Define o valor por hora
        Veiculo veiculoRegistrado = service.registrarEntrada(veiculo);
        return new ResponseEntity<>(veiculoRegistrado, HttpStatus.CREATED);
    }

    @PutMapping("/saída/{id}")
    public ResponseEntity<Veiculo> registrarSaida(@PathVariable Long id) {
        try {
            Veiculo veiculoSaida = service.registrarSaida(id);
            return new ResponseEntity<>(veiculoSaida, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping

    public ResponseEntity<List<Veiculo>> listarVeiculo(){
        List<Veiculo> veiculos = service.ListarVeiculo();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }


}