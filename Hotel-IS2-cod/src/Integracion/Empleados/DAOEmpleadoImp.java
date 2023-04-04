package Integracion.Empleados;

import Negocio.Empleados.TEmpleados;

import java.util.Collection;

public class DAOEmpleadoImp {

	public Integer crear(TEmpleados tEmpleados);

	public Integer borrar(Integer id);

	public Integer modificar(TEmpleados tEmpleados);

	public TEmpleados MostrarUno(Integer id);

	public Collection<TEmpleados> MostrarTodos();
	
}
