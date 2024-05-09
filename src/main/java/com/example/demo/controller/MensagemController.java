package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.Mensagem;
import com.example.demo.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping
    public ResponseEntity<List<Mensagem>> buscarTodos(){
        return ResponseEntity.ok(mensagemService.buscarTodos());
    }
}
