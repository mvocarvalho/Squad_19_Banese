package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Mensagem;
import com.example.demo.repository.MensagemRepository;
import com.example.demo.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemServiceImpl implements MensagemService {
    @Autowired
    private MensagemRepository mensagemRepository;
    @Override
    public List<Mensagem> buscarTodos() {
        return mensagemRepository.findAll();
    }

    @Override
    public Mensagem criar(Mensagem mensagem) {
        Mensagem msg = mensagemRepository.findById(mensagem.getId()).orElse(null);
        if(msg == null) {
            return mensagemRepository.save(mensagem);
        }
        throw new RuntimeException("Mensagem já existe");
    }

    @Override
    public Mensagem atualizar(Mensagem mensagem) {
        Mensagem msg = mensagemRepository.findById(mensagem.getId()).orElse(null);
        if(msg != null){
            return mensagemRepository.save(mensagem);
        }
        throw new RuntimeException("A mensagem não existe");
    }

    @Override
    public void remover(Integer id) {
        Mensagem msg = mensagemRepository.findById(id).orElse(null);
        if(msg != null){
            mensagemRepository.deleteById(id);
        } else{
            throw new RuntimeException("A mensagem não existe");
        }

    }

    @Override
    public Optional<Mensagem> buscarPorId(Integer id){
        return mensagemRepository.findById(id);
    }
}
