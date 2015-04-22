package org.inout.pedidovenda.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.inout.pedidovenda.GenericDao;
import org.inout.pedidovenda.model.Cliente;

public class ClienteDao extends GenericDao<Cliente> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Cliente> obterPor(String nome) {

		return this.manager
				.createQuery("from Cliente " + "where upper(nome) like :nome",
						Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

}
