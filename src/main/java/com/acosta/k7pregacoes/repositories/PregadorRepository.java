package com.acosta.k7pregacoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acosta.k7pregacoes.domain.Pregador;

@Repository
public interface PregadorRepository extends JpaRepository<Pregador, Integer> {
	
	
	
	// A classe PregadorService busca aqui este metodo que precisou ser criado por nao ter findByPregador no obj rep
	List<Pregador> findByPregador(String pregador);

}
