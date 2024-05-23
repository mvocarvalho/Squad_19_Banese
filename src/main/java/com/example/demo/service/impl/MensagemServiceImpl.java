package com.example.demo.service.impl;

import java.util.List;
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
    public List<Mensagem> getUnsentMessages() {
        return mensagemRepository.findAllByEnviadaFalse();
    }

    public void markAsSent(Mensagem mensagem) {
    	mensagem.setEnviada(true);
        mensagemRepository.save(mensagem);
    }

    
    public void enviarEmail(String destino, String conteudo) {
        
    }

    public void enviarSMS(String destino, String conteudo) {
        
    }

    public void enviarNotificacao(String destino, String conteudo) {
        
    }
}

