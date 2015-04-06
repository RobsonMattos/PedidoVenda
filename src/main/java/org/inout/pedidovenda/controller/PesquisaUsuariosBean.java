package org.inout.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.inout.pedidovenda.model.Usuario;
import org.inout.pedidovenda.service.UsuarioService;

@Named
@ViewScoped
public class PesquisaUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	
	private List<Usuario> usuariosFiltrados;

	
	public PesquisaUsuariosBean() {
		
	}
	
	public void pesquisar() {
		usuariosFiltrados = usuarioService.obter();
	}
	
	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
	
}