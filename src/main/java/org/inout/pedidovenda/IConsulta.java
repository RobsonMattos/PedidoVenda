package org.inout.pedidovenda;

import java.util.List;

/**
 * Interface com os métodos comuns de consulta
 * 
 * @author Robson Mattos
 * Data 03/04/2015
 * @param <T>
 */
public interface IConsulta <T> {

	/**
	 * Obtem todos os objetos
	 * @return
	 */
	List<T> obter();
	
	/**
	 * Obtem o objeto pelo id
	 * @param id
	 * @return
	 */
	T obter(Long id);
	
}
