package Integracion.Cliente;

import Negocio.Cliente.TCliente;

import java.util.Collection;

public interface DAOCliente {
		
	public Integer crear(TCliente tCliente);

	public Integer borrar(Integer id);

	public Integer modificar(TCliente tCliente);

	public TCliente MostrarUno(Integer id);

	public Collection<TCliente> MostrarTodos();

}
