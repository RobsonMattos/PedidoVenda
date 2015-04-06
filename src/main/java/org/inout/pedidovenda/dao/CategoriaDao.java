package org.inout.pedidovenda.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.inout.pedidovenda.GenericDao;
import org.inout.pedidovenda.model.Categoria;

public class CategoriaDao extends GenericDao<Categoria> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public List<Categoria> obter() {
		return manager.createQuery("from Categoria where categoriaPai is null",
				Categoria.class).getResultList();
	}

	@Override
	public Categoria obter(Long id) {
		return manager.find(Categoria.class, id);
	}

	public List<Categoria> obterSubCategorias(Categoria categoriaPai) {
		return manager
				.createQuery("from Categoria where categoriaPai = :pai",
						Categoria.class).setParameter("pai", categoriaPai)
				.getResultList();
	}

}