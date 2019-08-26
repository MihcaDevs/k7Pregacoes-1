 package com.acosta.k7pregacoes.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.acosta.k7pregacoes.domain.Pregador;
import com.acosta.k7pregacoes.repositories.PregadorRepository;

@Service
public class PregadorService {
	
	@Autowired
	private PregadorRepository rep;
	
	
	//metodo que lista  todos os pregadores
	public List<Pregador> getPregador() {
		return (List<Pregador>) rep.findAll();
	}
	
	//metodo que busca por id
	public Optional<Pregador> getPregadorById(Integer id) {
		return rep.findById(id);
	}
	
	//metodo faz a busca pelo nome do pregador no campo pregador
	public Iterable<Pregador> getPregadorByPregador(String pregador) {
		// TODO Auto-generated method stub
		return rep.findByPregador(pregador);
	}

	//metodo que salva o pregador
	public Pregador insert(Pregador pregador) {
		return rep.save(pregador);
		
	}
	
	//metodo que atualiza o pregador
	public Pregador update(Pregador pregador, Integer id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro");
		
		//Busca  o pregador no banco de dados
		Optional<Pregador> optional = getPregadorById(id);
		if(optional.isPresent()) {
			Pregador db = optional.get();
			//copiar as propriedades
			db.setPregador(pregador.getPregador());
			db.setTema(pregador.getTema());
			db.setLink(pregador.getLink());
			System.out.println("Carro id " + db.getId());
			
			//Atualiza o pregador
			rep.save(db);
			
			return db;
		
		} else {
			throw new RuntimeException("Não foi possível atualiza o registro");
		}
		
		
		
	}
	// deleta o pregador
	public void delete(Integer id) {
		Optional<Pregador> pregador = getPregadorById(id);
		if (pregador.isPresent()) {
		rep.deleteById(id);
		}
		
	}

}

