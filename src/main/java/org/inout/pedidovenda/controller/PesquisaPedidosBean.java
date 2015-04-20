package org.inout.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.inout.pedidovenda.model.Pedido;
import org.inout.pedidovenda.model.StatusPedido;
import org.inout.pedidovenda.service.PedidosService;
import org.inout.pedidovenda.service.filter.PedidoFilter;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidosService pedidosService;
	
	private PedidoFilter filtro;
	private List<Pedido> pedidosFiltrados;
	
	public PesquisaPedidosBean() {
		
		filtro = new PedidoFilter();
		pedidosFiltrados = new ArrayList<Pedido>();
	}

	public void pesquisar() {
		pedidosFiltrados = pedidosService.filtrados(filtro);
	}
	
	public StatusPedido[] getStatuses() {
		return StatusPedido.values();
	}
	
	public PedidoFilter getFiltro() {
		return filtro;
	}

	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}
	
}