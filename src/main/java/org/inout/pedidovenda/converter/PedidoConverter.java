package org.inout.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.inout.pedidovenda.dao.PedidoDao;
import org.inout.pedidovenda.model.Pedido;
import org.inout.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter {

	//@Inject
		private PedidoDao pedidoDao;
		
		public PedidoConverter() {
			pedidoDao = CDIServiceLocator.getBean(PedidoDao.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Pedido retorno = null;
			
			if (value != null) {
				retorno = pedidoDao.obter(new Long(value));
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				Pedido pedido = (Pedido) value;
				return pedido.getId() == null ? null : pedido.getId().toString();
			}
			
			return "";
		}
	
}
