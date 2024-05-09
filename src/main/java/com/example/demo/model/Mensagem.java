package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Mensagem {

    @Id
    @Column
    private Integer id;

    @Column
    private String descricao;
}
