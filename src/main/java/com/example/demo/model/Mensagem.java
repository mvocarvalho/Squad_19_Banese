package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mensagem {

    @Id
    @Column
    private Integer id;

    @Column
    private String descricao;
    @Column
    private String email;
    @Column
    private String sms; 
    @Column
    private String notificacao;
    @Column
    private String tipo;
    @Column
    private String destino;
    

	public void setEnviada(boolean b) {
		
		
	}


	public Object getTipo() {
		
		return null;
	}


	public String getDestino() {
		
		return null;
	}


	public String getConteudo() {
		return null;
	}
    
}
