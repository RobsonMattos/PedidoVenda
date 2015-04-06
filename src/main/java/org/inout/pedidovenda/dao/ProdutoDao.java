package org.inout.pedidovenda.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.inout.pedidovenda.GenericDao;
import org.inout.pedidovenda.model.Produto;

public class ProdutoDao extends GenericDao<Produto> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Produto obter(String sku) {
		try {
			return manager
					.createQuery("from Produto where sku = :sku", Produto.class)
					.setParameter("sku", sku).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
