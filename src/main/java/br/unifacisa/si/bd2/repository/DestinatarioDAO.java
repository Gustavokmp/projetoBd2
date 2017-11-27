package br.unifacisa.si.bd2.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.unifacisa.si.bd2.model.Destinatario;

@Repository
public class DestinatarioDAO extends DAO{
	
	public void begin() {
		super.getEntityManager().getTransaction().begin();
	}
	
	public void commit() {
		super.getEntityManager().getTransaction().commit();
	}
	
	public void rollback() {
		super.getEntityManager().getTransaction().rollback();
	}
	
	public void save(Destinatario destinatario) {
		this.begin();
		this.getEntityManager().persist(destinatario);
		this.commit();
	}

	public Destinatario findOne(long id) {
		Destinatario d;
		this.begin();
		d = this.getEntityManager().find(Destinatario.class, id);
		this.commit();
		return d;
	}

	public List<Destinatario> findAll() {
		Query query = this.getEntityManager().createQuery("select d from destinatarios d");
		List<Destinatario> list;
		this.begin();
		list = query.getResultList();
		this.commit();
		return list;
		
	}
	
	public Destinatario delete(long id) {
		this.begin();
		this.getEntityManager().remove(id);
		this.commit();
		return null;
	}

}
