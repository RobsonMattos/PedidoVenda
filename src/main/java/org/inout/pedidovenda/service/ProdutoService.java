package org.inout.pedidovenda.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.inout.pedidovenda.GenericService;
import org.inout.pedidovenda.dao.ProdutoDao;
import org.inout.pedidovenda.model.Produto;
import org.inout.pedidovenda.service.filter.ProdutoFilter;
import org.inout.pedidovenda.util.jpa.Transactional;

public class ProdutoService extends GenericService<ProdutoDao, Produto> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoDao dao;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Produto> Filtrar(ProdutoFilter produto) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);

		if (StringUtils.isNotBlank(produto.getSku())) {
			criteria.add(Restrictions.eq("sku", produto.getSku()));
		}

		if (StringUtils.isNotBlank(produto.getNome())) {
			criteria.add(Restrictions.ilike("nome", produto.getNome(),
					MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}

	@Override
	@Transactional
	public void salvar(Produto produto) {
		Produto produtoExistente = dao.obter(produto.getSku());

		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Produto com esse sku já existe!");
		}

		dao.salvar(produto);
	}

}
