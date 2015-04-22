package org.inout.pedidovenda;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.inout.pedidovenda.service.NegocioException;

@SuppressWarnings("unchecked")
public abstract class GenericDao<T> implements
		Serializable, IConsulta<T>, IPersist<T> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<T> obter() {
		return manager.createQuery(("from " + getTypeClass().getName()))
                .getResultList();
	}

	public T obter(Long id) {
		return (T) manager.find(getTypeClass(), id);
	}

	public T salvar(T objeto) {
		return manager.merge(objeto);
	}
	
	public void editar(T objeto) {
			
	}
	
	public void excluir(T objeto) {
		try {
			manager.remove(manager.contains(objeto) ? objeto : manager.merge(objeto));
			manager.flush();
		} catch(PersistenceException e) {
			throw new NegocioException("Registro não pode ser removido!");
		}
	}
	
	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}
}