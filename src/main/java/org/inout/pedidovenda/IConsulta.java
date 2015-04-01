package org.inout.pedidovenda;
import java.util.List;


public interface IConsulta <T> {

	List<T> obter();
	
	T obter(Long id);
	
}
