package com.acosta.k7pregacoes.domain.dto;

import com.acosta.k7pregacoes.domain.Pregador;

import lombok.Data;

@Data
public class PregadorDTO {	
	private Integer id;
	private String pregador;
	private String tema;
	private String link;
	
	
	public PregadorDTO(Pregador p)  {
		this.id = p.getId();
		this.pregador = p.getPregador();
		this.tema = p.getTema();
		this.link = p.getLink();
	}
	
	

}
