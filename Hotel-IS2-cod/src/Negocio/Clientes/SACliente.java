package Negocio.Clientes;

import java.util.Collection;

import Negocio.Clientes.TCliente;


public interface SACliente {
	public Integer crear(TCliente cliente);
	
	public Integer modificar(TCliente cliente);

	public Integer eliminar(int id);

	public TCliente mostrarUno(int id);
	
	public Collection<TCliente> mostrarTodos();
	
}
