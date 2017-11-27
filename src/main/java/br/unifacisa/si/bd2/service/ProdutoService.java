package br.unifacisa.si.bd2.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifacisa.si.bd2.model.Entrega;
import br.unifacisa.si.bd2.model.Produto;
import br.unifacisa.si.bd2.repository.ProdutoDAO;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	public void save(@Valid Produto produto) {
		this.produtoDao.save(produto);
	}
	
	public Produto findOne(long id) {
		Produto p = this.produtoDao.findOne(id);
		return p;
	}
	
	public List<Produto> findAll(){
		List<Produto> produtos = this.produtoDao.findAll();
		return produtos;
	}
	
	public Produto remove(long id) {
		Produto p = this.produtoDao.delete(id);;
		return p;
	}

}
