package org.inout.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.inout.pedidovenda.dao.GrupoDao;
import org.inout.pedidovenda.model.Grupo;
import org.inout.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

	private GrupoDao grupoDao;

	public GrupoConverter() {
		grupoDao = CDIServiceLocator.getBean(GrupoDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Grupo retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = grupoDao.obter(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			return ((Grupo) value).getId().toString();
		}

		return "";
	}

}
