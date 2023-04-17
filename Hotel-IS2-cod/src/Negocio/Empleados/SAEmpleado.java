package Negocio.Empleados;

import java.util.Collection;

import Negocio.Empleados.TEmpleados;

public interface SAEmpleado {
	
	public Integer crear(TEmpleados empleado);
	
	public Integer modificar(TEmpleados empleado);

	public Integer eliminar(int idEmpleado);

	public TEmpleados mostrarUno(int idEmpleado);
	
	public Collection<TEmpleados> mostrarTodos();
	
	public Collection<TEmpleados> mostrarPorDepartamento(Integer idDepartamento);
	
	public Integer vincular(TTareasDelEmpleado tTareasDelEmpleado);

	public Integer desvincular(TTareasDelEmpleado tTareasDelEmpleado);
	
	public Collection<TTareasDelEmpleado> Leertodos();

	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorTareas(Integer idTareas);
	
	public Collection<TTareasDelEmpleado> LeerLineasPedidoPorEmpleado(Integer idEmpleado);
}
