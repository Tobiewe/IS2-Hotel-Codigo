package Integracion.TareasDelEmpleado;

import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TTareasDelEmpleado;
import Negocio.Tareas.TTareas;

import java.util.Collection;

public interface DAOTareasDelEmpleado {

	public Integer crear(TTareasDelEmpleado tTareasDelEmpleado);

	public Integer eliminar(TTareasDelEmpleado tTareasDelEmpleado);
	
	public Collection<TTareasDelEmpleado> Leertodos();

	public Collection<TTareas> LeerLineasPedidoPorTareas(Integer idTareas);
	
	public Collection<TEmpleados> LeerLineasPedidoPorEmpleado(Integer idEmpleado);
	
}
