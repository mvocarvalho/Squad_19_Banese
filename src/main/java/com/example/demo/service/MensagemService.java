package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Mensagem;

public interface MensagemService {
    List<Mensagem> buscarTodos();
    Mensagem criar(Mensagem mensagem);
    Mensagem atualizar(Mensagem mensagem);
    void  remover(Integer id);
    Optional<Mensagem> buscarPorId(Integer id);

}

