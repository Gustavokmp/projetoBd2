package br.unifacisa.si.bd2.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifacisa.si.bd2.model.Entrega;
import br.unifacisa.si.bd2.repository.EntregaDAO;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaDAO entregaDao;
	
	public void save(@Valid Entrega entrega) {
		this.entregaDao.save(entrega);
	}
	
	public Entrega findOne(long id) {
		Entrega e = this.entregaDao.findOne(id);
		return e;
	}
	
	public List<Entrega> findAll(){
		List<Entrega> entregas = this.entregaDao.findAll();
		return entregas;
	}

}
