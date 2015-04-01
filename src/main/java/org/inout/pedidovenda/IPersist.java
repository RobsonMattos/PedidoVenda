package org.inout.pedidovenda;

public interface IPersist <T> { 
	
	void salvar(T objeto);
	void editar(T objeto);
	void excluir(T objeto);
	
}
