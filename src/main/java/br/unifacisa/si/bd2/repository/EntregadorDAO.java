package br.unifacisa.si.bd2.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.unifacisa.si.bd2.model.Entregador;



@Repository
public class EntregadorDAO extends DAO{
	
	public void begin() {
		super.getEntityManager().getTransaction().begin();
	}
	
	public void commit() {
		super.getEntityManager().getTransaction().commit();
	}
	
	public void rollback() {
		super.getEntityManager().getTransaction().rollback();
	}
	
	public void save(Entregador entregador) {
		this.begin();
		this.getEntityManager().persist(entregador);
		this.commit();
	}

	public Entregador findOne(long id) {
		Entregador e;
		this.begin();
		e = this.getEntityManager().find(Entregador.class, id);
		this.commit();
		return e;
	}

	public List<Entregador> findAll() {
		Query query = this.getEntityManager().createQuery("select e from entregadores d");
		List<Entregador> list;
		this.begin();
		list = query.getResultList();
		this.commit();
		return list;
		
	}
	
	public Entregador delete(long id) {
		this.begin();
		Entregador e = findOne(id);
		this.getEntityManager().remove(id);
		this.commit();
		return e;
	}

}
