package org.inout.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.inout.pedidovenda.model.Cliente;
import org.inout.pedidovenda.model.EnderecoEntrega;
import org.inout.pedidovenda.model.FormaPagamento;
import org.inout.pedidovenda.model.ItemPedido;
import org.inout.pedidovenda.model.Pedido;
import org.inout.pedidovenda.model.Produto;
import org.inout.pedidovenda.model.Usuario;
import org.inout.pedidovenda.service.ClienteService;
import org.inout.pedidovenda.service.PedidosService;
import org.inout.pedidovenda.service.ProdutoService;
import org.inout.pedidovenda.service.UsuarioService;
import org.inout.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private ClienteService clienteService;

	@Inject
	private ProdutoService produtoService;
	
	@Inject
	private PedidosService pedidoService;

	private String sku;

	private Pedido pedido;
	private List<Usuario> vendedores;

	private Produto produtoLinhaEditavel;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.vendedores = this.usuarioService.obterVendedores();

			this.pedido.adicionarItemVazio();

			this.recalcularPedido();
		}
	}

	private void limpar() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
	}

	public void salvar() {
		this.pedido = this.pedidoService.salvar(this.pedido);

		FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
	}

	public void recalcularPedido() {
		if (this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
	}

	public void carregarProdutoPorSku() {
		if (StringUtils.isNotEmpty(this.sku)) {
			this.produtoLinhaEditavel = this.produtoService.porSku(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}

	public void carregarProdutoLinhaEditavel() {
		ItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil
						.addErrorMessage("Já existe um item no pedido com o produto informado.");
			} else {
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel
						.getValorUnitario());

				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;

				this.pedido.recalcularValorTotal();
			}
		}
	}
	
	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;
		
		for (ItemPedido item : this.getPedido().getItens()) {
			if (produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}
		}
		
		return existeItem;
	}

	public List<Produto> completarProduto(String nome) {
		return this.produtoService.porNome(nome);
	}
	
	public FormaPagamento[] getFormasPagamento() {
		return FormaPagamento.values();
	}

	public List<Cliente> completarCliente(String nome) {
		return this.clienteService.obterPor(nome);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public boolean isEditando() {
		return this.pedido.getId() != null;
	}
	
	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
}