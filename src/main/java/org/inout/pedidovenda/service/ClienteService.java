package org.inout.pedidovenda.service;

import java.util.List;

import javax.inject.Inject;

import org.inout.pedidovenda.GenericService;
import org.inout.pedidovenda.model.Cliente;

public class ClienteService extends GenericService<ClienteDao, Cliente> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteDao dao;
	
	public List<Cliente> obterPor(String nome) {
		return dao.obterPor(nome);
	}
	
}
