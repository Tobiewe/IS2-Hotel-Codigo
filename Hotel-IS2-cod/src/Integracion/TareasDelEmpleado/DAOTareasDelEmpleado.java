package Integracion.TareasDelEmpleado;

import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TTareasDelEmpleado;
import Negocio.Tareas.TTareas;

import java.util.Collection;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

public interface DAOTareasDelEmpleado {

	public Integer crear(TTareasDelEmpleado tTareasDelEmpleado);

	public Integer eliminar(TTareasDelEmpleado tTareasDelEmpleado);
	
	public Collection<TTareas> LeerLineasPedidoPorTareas(Integer idTareas);
	
	public Collection<TEmpleados> LeerLineasPedidoPorEmpleado(Integer idEmpleado);
	
}
