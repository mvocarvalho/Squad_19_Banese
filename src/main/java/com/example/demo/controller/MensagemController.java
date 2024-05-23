package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.Mensagem;
import com.example.demo.service.MensagemService;
import com.example.demo.service.impl.MensagemServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping
    public ResponseEntity<List<Mensagem>> buscarTodos(){
        return ResponseEntity.ok(mensagemService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Mensagem> criar(@RequestBody Mensagem mensagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemService.criar(mensagem));
    }

    @PutMapping
    public ResponseEntity<Mensagem> atualizar(@RequestBody Mensagem mensagem){
        return ResponseEntity.ok(mensagemService.atualizar(mensagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover (@PathVariable Integer id){
        mensagemService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(mensagemService.buscarPorId(id).orElse(null));
    }
}

