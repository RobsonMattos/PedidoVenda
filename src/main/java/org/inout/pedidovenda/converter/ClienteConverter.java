package org.inout.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.inout.pedidovenda.model.Cliente;
import org.inout.pedidovenda.service.ClienteDao;
import org.inout.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	// @Inject
	private ClienteDao clientes;

	public ClienteConverter() {
		this.clientes = CDIServiceLocator.getBean(ClienteDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Cliente retorno = null;

		if (value != null) {
			retorno = this.clientes.obter(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			return ((Cliente) value).getId().toString();
		}
		return "";
	}

}