package Integracion.TareasDelEmpleado;

import Negocio.Empleados.TTareasDelEmpleado;

import java.util.Collection;

public interface DAOTareasDelEmpleado {

	public Integer crear(TTareasDelEmpleado tTareasDelEmpleado);

	public Integer modificar(TTareasDelEmpleado tTareasDelEmpleado);
	
	public Collection<TTareasDelEmpleado> Leertodos();

	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorTareas(Integer idTareas);
	
	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorEmpleado(Integer idEmpleado);
	
}
