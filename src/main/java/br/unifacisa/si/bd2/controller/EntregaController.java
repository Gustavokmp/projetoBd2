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


import br.unifacisa.si.bd2.model.Entrega;
import br.unifacisa.si.bd2.service.EntregaService;

@RestController
@RequestMapping("/api")
public class EntregaController {
	
	private EntregaService entregaService;
	
	@PostMapping("/entrega")
	public ResponseEntity<String> createEntrega(@Valid @RequestBody Entrega entrega){
		this.entregaService.save(entrega);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@GetMapping("/entrega")
	public ResponseEntity<List<Entrega>> getEntrega(){
		List<Entrega> entregas = this.entregaService.findAll();
		return new ResponseEntity<List<Entrega>>(entregas, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/entrega/{id}")
	public ResponseEntity<Entrega> getEntrega(@PathVariable int id){
		Entrega entrega = this.entregaService.findOne(id);
		return new ResponseEntity<Entrega>(entrega, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/entrega/{id}")
	public ResponseEntity<Entrega> deleteEntrega(@PathVariable int id){
		Entrega entrega = this.entregaService.remove(id);
		return new ResponseEntity<Entrega>(entrega, HttpStatus.ACCEPTED);
	}

}
