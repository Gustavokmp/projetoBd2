package br.unifacisa.si.bd2.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.unifacisa.si.bd2.model.Empresa;



@Repository
public class EmpresaDAO extends DAO{
	
	public void begin() {
		super.getEntityManager().getTransaction().begin();
	}
	
	public void commit() {
		super.getEntityManager().getTransaction().commit();
	}
	
	public void rollback() {
		super.getEntityManager().getTransaction().rollback();
	}
	
	public void save(Empresa empresa) {
		this.begin();
		this.getEntityManager().persist(empresa);
		this.commit();
	}

	public Empresa findOne(long id) {
		Empresa e;
		this.begin();
		e = this.getEntityManager().find(Empresa.class, id);
		this.commit();
		return e;
	}

	public List<Empresa> findAll() {
		Query query = this.getEntityManager().createQuery("select e from empresas d");
		List<Empresa> list;
		this.begin();
		list = query.getResultList();
		this.commit();
		return list;
		
	}
	
	public void delete(long id) {
		this.begin();
		this.getEntityManager().remove(id);
		this.commit();
	}

}
