package org.inout.pedidovenda;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.inout.pedidovenda.util.jpa.Transactional;

public abstract class GenericService<O extends GenericDao<T>, T> implements
		Serializable, IConsulta<T>, IPersist<T> {

	private static final long serialVersionUID = 1L;

	@Inject
	private O dao;

	public List<T> obter() {
		return (List<T>) dao.obter();
	}

	public T obter(Long id) {
		return (T) dao.obter(id);
	}
	
	@Transactional
	public T salvar(T objeto) {
		return dao.salvar(objeto);
	}
	
	@Transactional
	public void editar(T objeto) {
		// not implement
	}
	
	@Transactional
	public void excluir(T objeto) {
		dao.excluir(objeto);
	}
}