package br.unifacisa.si.bd2.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.unifacisa.si.bd2.model.Entrega;



@Repository
public class EntregaDAO extends DAO{
	
	public void begin() {
		super.getEntityManager().getTransaction().begin();
	}
	
	public void commit() {
		super.getEntityManager().getTransaction().commit();
	}
	
	public void rollback() {
		super.getEntityManager().getTransaction().rollback();
	}
	
	public void save(Entrega entrega) {
		this.begin();
		this.getEntityManager().persist(entrega);
		this.commit();
	}

	public Entrega findOne(long id) {
		Entrega e;
		this.begin();
		e = this.getEntityManager().find(Entrega.class, id);
		this.commit();
		return e;
	}

	public List<Entrega> findAll() {
		Query query = this.getEntityManager().createQuery("select e from entregas d");
		List<Entrega> list;
		this.begin();
		list = query.getResultList();
		this.commit();
		return list;
		
	}
	
	public Entrega delete(long id) {
		this.begin();
		Entrega e = findOne(id);
		this.getEntityManager().remove(e);
		this.commit();
		return e;
	}

}
