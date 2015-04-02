package org.inout.pedidovenda;


/**
 * 
 * @author robson.Mattos
 *
 * @param <T>
 */
public interface IPersist <T> { 
	
	/**
	 * Salva registro
	 * @param objeto
	 */
	void salvar(T objeto);
	
	/**
	 * Edita registro
	 * @param objeto
	 */
	void editar(T objeto);
	
	/**
	 * Excluir registro
	 * @param objeto
	 */
	void excluir(T objeto);
	
}
