package br.unifacisa.si.bd2.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifacisa.si.bd2.model.Empresa;
import br.unifacisa.si.bd2.repository.EmpresaDAO;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaDAO empresaDao;
	
	public void save(@Valid Empresa empresa) {
		this.empresaDao.save(empresa);
	}
	
	public Empresa findOne(long id) {
		Empresa e = this.empresaDao.findOne(id);
		return e;
	}
	
	public List<Empresa> findAll(){
		List<Empresa> empresas = this.empresaDao.findAll();
		return empresas;
	}
	
	public Empresa remove(long id) {
		Empresa e = this.empresaDao.delete(id);;
		return e;
	}

}
