package com.acosta.k7pregacoes.domain.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acosta.k7pregacoes.domain.Pregador;
import com.acosta.k7pregacoes.domain.services.PregadorService;

@RestController
@RequestMapping("/api/v1/pregadores")
public class PregadorResource {
	
	@Autowired()
	private PregadorService service;
	
	@GetMapping()
	public Iterable<Pregador> get() {
	return service.getPregador();
	
	}
	
	@GetMapping("/{id}")
	public Optional<Pregador> get(@PathVariable("id") Integer id) {
		return service.getPregadorById(id);
	}
	
	@GetMapping("/pregador/{pregador}")
	public Iterable<Pregador> get(@PathVariable("pregador") String pregador) {
		return service.getPregadorByPregador(pregador);
	}
	
	@PostMapping
	public String post(@RequestBody Pregador pregador) {
		Pregador p = service.insert(pregador);
		
		return "Pregador salvo com sucesso: " + p.getId();
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Integer id, @RequestBody Pregador pregador) {
		
		Pregador p = service.update(pregador, id);
		
		return "Carro atualizado com sucesso: "  + p.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		service.delete(id);
		
		return "Carro deletado com sucesso";
		
	}
	

}
