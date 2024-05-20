package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Mensagem;
import com.example.demo.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {
    @Autowired
    private MensagemService mensagemService;

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
