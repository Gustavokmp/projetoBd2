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


import br.unifacisa.si.bd2.model.Produto;
import br.unifacisa.si.bd2.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	private ProdutoService produtoService;
	
	@PostMapping("/produto")
	public ResponseEntity<String> createEntregador(@Valid @RequestBody Produto produto){
		this.produtoService.save(produto);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> getEntregador(){
		List<Produto> produtos = this.produtoService.findAll();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getEntregador(@PathVariable int id){
		Produto produto = this.produtoService.findOne(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Produto> deleteEntregador(@PathVariable int id){
		Produto produto = this.produtoService.remove(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.ACCEPTED);
	}

}
