package com.acosta.k7pregacoes.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acosta.k7pregacoes.domain.Pregador;
import com.acosta.k7pregacoes.services.PregadorService;

@RestController
@RequestMapping("/api/v1/pregadores")
public class PregadorResource {
	
	@Autowired()
	private PregadorService service;
	
	@GetMapping()
	public ResponseEntity<Iterable<Pregador>> get() {
	return ResponseEntity.ok(service.getPregador());
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Integer id) {
		Optional<Pregador> pregador = service.getPregadorById(id);
		
		return pregador
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	@GetMapping("/pregador/{pregador}")
	public ResponseEntity getCarrosByPregador(@PathVariable("pregador") String pregador) {
		List<Pregador> pregadores= service.getPregadorByPregador(pregador);
		
		return pregadores.isEmpty() ?
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(pregadores);
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
