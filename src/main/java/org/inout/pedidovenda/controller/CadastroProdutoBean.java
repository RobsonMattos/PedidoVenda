package org.inout.pedidovenda.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.inout.pedidovenda.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Produto produto;

	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void salvar() {
	}
	
	public Produto getProduto() {
		return produto;
	}
	
}