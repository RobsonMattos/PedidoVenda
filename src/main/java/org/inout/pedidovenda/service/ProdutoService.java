package org.inout.pedidovenda.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.inout.pedidovenda.IConsulta;
import org.inout.pedidovenda.IPersist;
import org.inout.pedidovenda.dao.ProdutoDao;
import org.inout.pedidovenda.model.Produto;
import org.inout.pedidovenda.service.filter.ProdutoFilter;
import org.inout.pedidovenda.util.jpa.Transactional;

public class ProdutoService implements IConsulta<Produto>,
		IPersist<Produto>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
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
	
	@SuppressWarnings("unchecked")
	public List<Produto> Filtrar(ProdutoFilter produto) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if (StringUtils.isNotBlank(produto.getSku())) {
			criteria.add(Restrictions.eq("sku", produto.getSku()));
		}
		
		if (StringUtils.isNotBlank(produto.getNome())) {
			criteria.add(Restrictions.ilike("nome", produto.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}
	
	@Override @Transactional
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
