package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.Mensagem;
import com.example.demo.service.MensagemService;
import com.example.demo.service.impl.MensagemServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;
    
    @Autowired
    private MensagemServiceImpl mensagemServiceimpl;

    @GetMapping
    public ResponseEntity<List<Mensagem>> buscarTodos(){
        return ResponseEntity.ok(mensagemService.buscarTodos());
        
    }
    @PostMapping("/enviarMensagem")
    public void enviarMensagens() {
        List<Mensagem> mensagens = mensagemServiceimpl.getUnsentMessages();
        
        for (Mensagem mensagem : mensagens) {
            switch (mensagem.getTipo().toString().toLowerCase()) {
                case "email":
                	mensagemServiceimpl.enviarEmail(mensagem.getDestino(), mensagem.getConteudo());
                    break;
                case "sms":
                	mensagemServiceimpl.enviarSMS(mensagem.getDestino(), mensagem.getConteudo());
                    break;
                case "notificacao":
                	mensagemServiceimpl.enviarNotificacao(mensagem.getDestino(), mensagem.getConteudo());
                    break;
                default:
                    
                    break;
            }
            mensagemServiceimpl.markAsSent(mensagem);
            
        }
    }
}

