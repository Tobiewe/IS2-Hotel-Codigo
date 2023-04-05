package Negocio.Departamentos;

import java.util.Collection;

import Negocio.Departamentos.TDepartamento;

public interface SADepartamento {
public Integer crear(TDepartamento empleado);
	
	public Integer modificar(TDepartamento empleado);

	public Integer eliminar(int id);

	public TEmpleados mostrarUno(int id);
	
	public Collection<TDepartamento> mostrarTodos();
}
