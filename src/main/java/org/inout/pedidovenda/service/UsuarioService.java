package org.inout.pedidovenda.service;

import java.util.List;

import javax.inject.Inject;

import org.inout.pedidovenda.GenericService;
import org.inout.pedidovenda.dao.UsuarioDao;
import org.inout.pedidovenda.model.Usuario;

public class UsuarioService extends GenericService<UsuarioDao, Usuario> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDao dao;
	
	public List<Usuario> obterVendedores() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return dao.obterVendedores();
	}

}
