package Integracion.TareasDelEmpleado;

import Negocio.TareasDelEmpleado.TTareasDelEmpleado;

import java.util.Collection;

public interface DAOTareasDelEmpleado {

	public Integer crear(TTareasDelEmpleado tTareasDelEmpleado);

	public Integer eliminar(Integer id);

	public Integer modificar(TTareasDelEmpleado tTareasDelEmpleado);

	public TTareasDelEmpleado LeerUno(Integer id);
	
	public Collection<TTareasDelEmpleado> Leertodos();

	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorTareas(int idTareas);
	
	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorEmpleado(int idEmpleado);
	
}
