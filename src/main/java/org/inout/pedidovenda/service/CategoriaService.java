package org.inout.pedidovenda.service;

import java.util.List;

import javax.inject.Inject;

import org.inout.pedidovenda.GenericService;
import org.inout.pedidovenda.dao.CategoriaDao;
import org.inout.pedidovenda.model.Categoria;

public class CategoriaService  extends GenericService<CategoriaDao, Categoria>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaDao categoriaDao;
	
	public List<Categoria> obterSubCategorias(Categoria categoriaPai) {
		return categoriaDao.obterSubCategorias(categoriaPai);
	}
	
}