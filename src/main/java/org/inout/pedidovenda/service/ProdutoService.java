package org.inout.pedidovenda.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.inout.pedidovenda.IConsulta;
import org.inout.pedidovenda.IPersist;
import org.inout.pedidovenda.dao.ProdutoDao;
import org.inout.pedidovenda.model.Produto;

public class ProdutoService implements IConsulta<Produto>,
		IPersist<Produto>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoDao produtoDao;
	
	@Override
	public List<Produto> obter() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Produto obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void salvar(Produto produto) {
		Produto produtoExistente = produtoDao.obter(produto.getSku());
		
		if(produtoExistente != null) {
			throw new NegocioException("Produto com esse sku já existe!");
		}
		
		produtoDao.salvar(produto);
	}

	@Override
	public void editar(Produto produto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Produto produto) {
		// TODO Auto-generated method stub

	}

}
