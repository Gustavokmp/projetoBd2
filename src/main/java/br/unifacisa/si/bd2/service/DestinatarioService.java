package br.unifacisa.si.bd2.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifacisa.si.bd2.model.Destinatario;
import br.unifacisa.si.bd2.repository.DestinatarioDAO;

@Service
public class DestinatarioService {
	
	@Autowired
	private DestinatarioDAO destinatarioDao;
	
	public void save(@Valid Destinatario destinatario) {
		this.destinatarioDao.save(destinatario);
	}
	
	public Destinatario findOne(long id) {
		Destinatario d = this.destinatarioDao.findOne(id);
		return d;
	}
	
	public List<Destinatario> findAll(){
		List<Destinatario> destinatarios = this.destinatarioDao.findAll();
		return destinatarios;
	}
	
	public Destinatario remove(long id) {
		Destinatario d = this.destinatarioDao.delete(id);;
		return d;
	}

}
