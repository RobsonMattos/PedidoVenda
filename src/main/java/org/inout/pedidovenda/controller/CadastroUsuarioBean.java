package org.inout.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.inout.pedidovenda.model.Grupo;
import org.inout.pedidovenda.model.Usuario;
import org.inout.pedidovenda.service.GrupoService;
import org.inout.pedidovenda.service.UsuarioService;
import org.inout.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private GrupoService grupoService;
	
	private Grupo grupo;
	private List<Grupo> grupos;
	private Usuario usuario;
	
	public CadastroUsuarioBean() {
		usuario = new Usuario();
	}
	
	public void inicializar() {
		if(!FacesUtil.isPostback())
			setGrupos(grupoService.obter());
	}
	
	public void salvar() {
		usuario.getGrupos().add(grupo);
		usuarioService.salvar(usuario);
	}
	
	public boolean isEditando() {
		return usuario.getId() != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	@NotNull
	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
}
