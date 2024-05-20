package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class Mensagem {

    @Id
    @Column
    private Integer id;

    @Column
    private String descricao;
}
