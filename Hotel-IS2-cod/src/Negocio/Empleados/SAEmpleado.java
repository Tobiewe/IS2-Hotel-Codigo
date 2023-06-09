package Negocio.Empleados;

import java.util.Collection;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Negocio.Empleados.TEmpleados;
import Negocio.Tareas.TTareas;

public interface SAEmpleado {
	
	public Integer crear(TEmpleados empleado);
	
	public Integer modificar(TEmpleados empleado);

	public Integer eliminar(int idEmpleado);

	public TEmpleados mostrarUno(int idEmpleado);
	
	public Collection<TEmpleados> mostrarTodos();
	
	public Collection<TEmpleados> mostrarPorDepartamento(Integer idDepartamento);
	
	public Integer vincular(TTareasDelEmpleado tTareasDelEmpleado);

	public Integer desvincular(TTareasDelEmpleado tTareasDelEmpleado);
	
	public Collection<TEmpleados> LeerLineasPedidoPorTareas(Integer idTareas);
	
	public Collection<TTareas> LeerLineasPedidoPorEmpleado(Integer idEmpleado);
}
