package org.inout.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.inout.pedidovenda.model.Categoria;
import org.inout.pedidovenda.model.Produto;
import org.inout.pedidovenda.service.CategoriaService;
import org.inout.pedidovenda.service.ProdutoService;
import org.inout.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaService categoriaService;
	
	@Inject
	private ProdutoService produtoService;
	
	private Produto produto;

	private Categoria categoriaPai;
	private List<Categoria> categorias;
	private List<Categoria> subCategorias;
	
	public CadastroProdutoBean() {
		limpar();
	}
	
	private void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subCategorias = new ArrayList<>();
	}
	
	public void inicializar() {
		if(!FacesUtil.isPostback())
			categorias = categoriaService.obter();
		
		if(this.categoriaPai != null) {
			carregarSubCategorias();
		}
	}
	
	public void salvar() {
		produtoService.salvar(produto);
		limpar();
		
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}
	
	public void carregarSubCategorias() {
		subCategorias = categoriaService.obterSubCategorias(categoriaPai);
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
		if(this.produto != null){
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
	}
	
	public boolean isEditando() {
		return this.produto.getId() != null;
	}
	
	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}
	
}