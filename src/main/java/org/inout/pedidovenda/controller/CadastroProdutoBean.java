package org.inout.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.inout.pedidovenda.dao.CategoriaDao;
import org.inout.pedidovenda.model.Categoria;
import org.inout.pedidovenda.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	
	@Inject
	private CategoriaDao categoriaDao;
	private Categoria categoriaPai;
	private List<Categoria> categoriasRaizes;
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar() {
		categoriasRaizes = categoriaDao.raizes();
	}
	
	public void salvar() {
	
		System.out.println("Categoria Pai selecionada = " + categoriaPai.getDescricao());
		
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}
	
}
