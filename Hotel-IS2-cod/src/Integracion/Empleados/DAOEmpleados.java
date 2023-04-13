package Integracion.Empleados;

import java.util.Collection;

import Negocio.Empleados.TEmpleados;

public interface DAOEmpleados {
	
	public Integer crear(TEmpleados tEmpleados);

	public Integer borrar(Integer id);

	public Integer modificar(TEmpleados tEmpleados);

	public TEmpleados MostrarUno(Integer id);

	public Collection<TEmpleados> MostrarTodos();
	
	public Collection<TEmpleados> mostrarPorDepartamento(Integer idDepartamento);
	
}
