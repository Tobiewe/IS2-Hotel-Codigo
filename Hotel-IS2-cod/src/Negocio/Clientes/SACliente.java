package Negocio.Clientes;

import java.util.Collection;

import Negocio.Empleados.TEmpleados;


public interface SACliente {
	public Integer crear(TEmpleados empleado);
	
	public Integer modificar(TEmpleados empleado);

	public Integer eliminar(int id);

	public TEmpleados mostrarUno(int id);
	
	public Collection<TEmpleados> mostrarTodos();
	
	public 
}
