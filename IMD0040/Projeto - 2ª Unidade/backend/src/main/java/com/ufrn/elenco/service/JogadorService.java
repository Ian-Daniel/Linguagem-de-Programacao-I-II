package com.ufrn.elenco.service;

import com.ufrn.elenco.model.Jogador;
import com.ufrn.elenco.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository repo;

    public JogadorService(JogadorRepository repo) {
        this.repo = repo;
    }

    public List<Jogador> listar() {
        return repo.findAll();
    }

    public Jogador buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Jogador criar(Jogador jogador) {
        return repo.save(jogador);
    }

    public void atualizar(Long id, Jogador jogador) {
        repo.update(id, jogador);
    }

    public void excluir(Long id) {
        repo.delete(id);
    }
}