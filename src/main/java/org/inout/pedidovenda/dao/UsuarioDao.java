package org.inout.pedidovenda.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.inout.pedidovenda.GenericDao;
import org.inout.pedidovenda.model.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public List<Usuario> obterVendedores() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}
	
}
