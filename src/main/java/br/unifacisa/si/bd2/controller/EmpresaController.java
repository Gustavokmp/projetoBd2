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

import br.unifacisa.si.bd2.model.Empresa;
import br.unifacisa.si.bd2.service.EmpresaService;

@RestController
@RequestMapping("/api")
public class EmpresaController {
	
	private EmpresaService empresaService;
	
	@PostMapping("/empresa")
	public ResponseEntity<String> createEmpresa(@Valid @RequestBody Empresa empresa){
		this.empresaService.save(empresa);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@GetMapping("/empresa")
	public ResponseEntity<List<Empresa>> getEmpresa(){
		List<Empresa> empresas = this.empresaService.findAll();
		return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/empresa/{id}")
	public ResponseEntity<Empresa> getEmpresa(@PathVariable int id){
		Empresa empresa = this.empresaService.findOne(id);
		return new ResponseEntity<Empresa>(empresa, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/empresa/{id}")
	public ResponseEntity<Empresa> deleteEmpresa(@PathVariable int id){
		Empresa empresa = this.empresaService.remove(id);
		return new ResponseEntity<Empresa>(empresa, HttpStatus.ACCEPTED);
	}

}
