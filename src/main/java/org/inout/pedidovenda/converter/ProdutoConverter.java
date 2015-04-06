package org.inout.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.inout.pedidovenda.dao.ProdutoDao;
import org.inout.pedidovenda.model.Produto;
import org.inout.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

	// @Inject
	private ProdutoDao produtos;

	public ProdutoConverter() {
		produtos = CDIServiceLocator.getBean(ProdutoDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Produto retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = produtos.obter(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Produto produto = (Produto) value;
			return produto.getId() == null ? null : produto.getId().toString();
		}

		return "";
	}

}