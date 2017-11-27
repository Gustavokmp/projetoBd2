package br.unifacisa.si.bd2.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.unifacisa.si.bd2.model.Entregador;
import br.unifacisa.si.bd2.repository.EntregadorDAO;

@Service
public class EntregadorService {
	
	@Autowired
	private EntregadorDAO entregadorDao;
	
	public void save(@Valid Entregador entregador) {
		this.entregadorDao.save(entregador);
	}
	
	public Entregador findOne(long id) {
		Entregador e = this.entregadorDao.findOne(id);
		return e;
	}
	
	public List<Entregador> findAll(){
		List<Entregador> entregadores = this.entregadorDao.findAll();
		return entregadores;
	}
	
	public Entregador remove(long id) {
		Entregador e = this.entregadorDao.delete(id);;
		return e;
	}

}
