package org.inout.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.inout.pedidovenda.dao.CategoriaDao;
import org.inout.pedidovenda.model.Categoria;
import org.inout.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter{
	
	//@Inject
		private CategoriaDao categorias;
		
		public CategoriaConverter() {
			categorias = CDIServiceLocator.getBean(CategoriaDao.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Categoria retorno = null;
			
			if (value != null) {
				Long id = new Long(value);
				retorno = categorias.porId(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				return ((Categoria) value).getId().toString();
			}
			
			return "";
		}

}
