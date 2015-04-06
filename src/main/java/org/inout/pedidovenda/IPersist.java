package org.inout.pedidovenda;


/**
 * Interface com métodos comuns de persistencia
 * 
 * @author robson.Mattos
 * Data 03/04/2015
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
