package org.inout.pedidovenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.inout.pedidovenda.IConsulta;
import org.inout.pedidovenda.IPersist;
import org.inout.pedidovenda.model.Produto;

public class ProdutoDao implements IConsulta<Produto>, IPersist<Produto>,
		Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

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
	
	public Produto obter(String sku) {
		try {
			return manager.createQuery("from Produto where sku = :sku", Produto.class)
					.setParameter("sku", sku)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void salvar(Produto produto) {
		EntityTransaction t = manager.getTransaction();
		t.begin();
		manager.merge(produto);
		t.commit();
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
