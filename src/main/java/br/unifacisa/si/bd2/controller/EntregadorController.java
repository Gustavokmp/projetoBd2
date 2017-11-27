package br.unifacisa.si.bd2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifacisa.si.bd2.model.Entregador;
import br.unifacisa.si.bd2.service.EntregadorService;

@RestController
@RequestMapping("/api")
public class EntregadorController {
	
	private EntregadorService entregadorService;
	
	@PostMapping("/entregador")
	public ResponseEntity<String> createEntregador(@Valid @RequestBody Entregador entregador){
		this.entregadorService.save(entregador);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@GetMapping("/entregador")
	public ResponseEntity<List<Entregador>> getEntregador(){
		List<Entregador> entregadores = this.entregadorService.findAll();
		return new ResponseEntity<List<Entregador>>(entregadores, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/entregador/{id}")
	public ResponseEntity<Entregador> getEntregador(@PathVariable int id){
		Entregador entregador = this.entregadorService.findOne(id);
		return new ResponseEntity<Entregador>(entregador, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/entregador/{id}")
	public ResponseEntity<Entregador> deleteEntregador(@PathVariable int id){
		Entregador entregador = this.entregadorService.remove(id);
		return new ResponseEntity<Entregador>(entregador, HttpStatus.ACCEPTED);
	}

}
