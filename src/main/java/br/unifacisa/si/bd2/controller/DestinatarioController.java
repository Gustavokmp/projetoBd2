package br.unifacisa.si.bd2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifacisa.si.bd2.model.Destinatario;
import br.unifacisa.si.bd2.service.DestinatarioService;

@RestController
@RequestMapping("/api")
public class DestinatarioController {
	
	@Autowired
	private DestinatarioService destinatarioService;
	
	@PostMapping("/destinatario")
	public ResponseEntity<String> createDestinatario(@Valid @RequestBody Destinatario destinatario){
		this.destinatarioService.save(destinatario);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@GetMapping("/destinatario")
	public ResponseEntity<List<Destinatario>> getProducts(){
		List<Destinatario> destinatarios = this.destinatarioService.findAll();
		return new ResponseEntity<List<Destinatario>>(destinatarios, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/destinatario/{id}")
	public ResponseEntity<Destinatario> getDestinatario(@PathVariable int id){
		Destinatario destinatario = this.destinatarioService.findOne(id);
		return new ResponseEntity<Destinatario>(destinatario, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/destinatario/{id}")
	public ResponseEntity<Destinatario> deleteDestinatario(@PathVariable int id){
		Destinatario destinatario = this.destinatarioService.remove(id);
		return new ResponseEntity<Destinatario>(destinatario, HttpStatus.ACCEPTED);
	}
	
	
	

}
