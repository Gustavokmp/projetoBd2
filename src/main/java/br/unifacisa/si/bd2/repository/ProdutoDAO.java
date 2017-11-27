package br.unifacisa.si.bd2.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.unifacisa.si.bd2.model.Produto;

@Repository
public class ProdutoDAO extends DAO {

	public void begin() {
		super.getEntityManager().getTransaction().begin();
	}

	public void commit() {
		super.getEntityManager().getTransaction().commit();
	}

	public void rollback() {
		super.getEntityManager().getTransaction().rollback();
	}

	public void save(Produto produto) {
		this.begin();
		this.getEntityManager().persist(produto);
		this.commit();
	}

	public Produto findOne(long id) {
		Produto p;
		this.begin();
		p = this.getEntityManager().find(Produto.class, id);
		this.commit();
		return p;
	}

	public List<Produto> findAll() {
		Query query = this.getEntityManager().createQuery("select p from produtos d");
		List<Produto> list;
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
