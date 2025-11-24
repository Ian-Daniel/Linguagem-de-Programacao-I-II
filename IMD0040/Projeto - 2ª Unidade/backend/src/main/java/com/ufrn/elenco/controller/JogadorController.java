package com.ufrn.elenco.controller;

import com.ufrn.elenco.model.Jogador;
import com.ufrn.elenco.service.JogadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService service;

    public JogadorController(JogadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jogador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Jogador buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public Jogador criar(@RequestBody Jogador jogador) {
        return service.criar(jogador);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Jogador jogador) {
        service.atualizar(id, jogador);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}