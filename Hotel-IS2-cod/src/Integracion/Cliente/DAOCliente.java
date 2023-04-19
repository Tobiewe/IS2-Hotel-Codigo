package Integracion.Cliente;

import Negocio.Clientes.TCliente;
import Negocio.Clientes.TEmpresa;
import Negocio.Clientes.TParticular;

import java.util.Collection;

public interface DAOCliente {
		
	public Integer crear(TCliente tCliente);

	public Integer borrar(Integer id);

	public Integer modificar(TCliente tCliente);

	public TCliente MostrarUno(Integer id);

	public Collection<TCliente> MostrarTodos();
	
	public Collection<TParticular> MostrarParticular();
	
	public Collection<TEmpresa> MostrarEmpresa();

}
